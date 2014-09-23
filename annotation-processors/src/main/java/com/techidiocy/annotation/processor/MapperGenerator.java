/**
 * 
 */
package com.techidiocy.annotation.processor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





/**
 * @author saurabhj
 *
 */
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

import com.techidiocy.annotation.FieldMeta;
import com.techidiocy.annotation.Relation;

@SupportedAnnotationTypes(value = { "com.techidiocy.annotation.Relation" })
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class MapperGenerator extends AbstractProcessor {
	
	private static final String EXTRA_SPACE = "   ";
	private static final String IMPORT = "import";

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		// This loop will process all the classes annotated with @Relation
		for (Element element : roundEnv
				.getElementsAnnotatedWith(Relation.class)) {
			Relation objectparam = element.getAnnotation(Relation.class);
			TypeMirror mirror = getEntity(objectparam);
			TypeElement typeElement = asTypeElement(mirror);
			String sourceClassName = typeElement.getSimpleName().toString();
			String sourceFQCN = typeElement.getQualifiedName().toString();
			String dtoFQCN = element.asType().toString();
			String dtoName = element.getSimpleName().toString();

			try {
				Object dtoInstance = Class.forName(dtoFQCN).newInstance();
				Class dtoClassInstance = dtoInstance.getClass();
				Object sourceInstance = Class.forName(sourceFQCN).newInstance();
				Class sourceClassInstance = sourceInstance.getClass();

				List<Field> fields = getAllFields(dtoClassInstance);
				
				StringBuilder mapperImportStatements = new StringBuilder();

				TypeElement classElement = (TypeElement) element;
				PackageElement packageElement = (PackageElement) classElement
						.getEnclosingElement();
				JavaFileObject jfo = processingEnv.getFiler().createSourceFile(
						packageElement.getQualifiedName() + ".mapper."
								+ sourceClassName + "Mapper");
				BufferedWriter bw = new BufferedWriter(jfo.openWriter());
				Date d = new Date();
				bw.append("/**Auto generated code,don't modify it.\n");
				bw.append("* Author             ---- > Auto Generated.\n");
				bw.append("* Date  and Time     ---- > " + d.toString() + "\n");
				bw.append("* Source             -----> " + sourceFQCN + "\n");
				bw.append("* Destination        -----> " + dtoFQCN + "\n");
				bw.append("*");
				bw.append("**/\n\n\n\n");

				bw.append("package " + packageElement.getQualifiedName()
						+ ".mapper;\n");
				bw.newLine();
				bw.newLine();

				bw.append("import java.util.ArrayList;\n");
				bw.append("import java.util.List;\n");
				bw.append("import java.util.Date;\n");
				
				bw.append("import "+sourceFQCN+";\n");
				bw.append("import "+dtoFQCN+";\n");
				
				bw.append(mapperImportStatements.toString());
				
				//Add all the import statements
				for(Field field: fields){ 
					Class<?> fieldType = field.getType();
					if(fieldType.getSimpleName().equals("List")) { 
						Type genericType = field.getGenericType();			
			    		String genericClassName = getGenericClassName(genericType);
						if(!checkPrimitiveOrWrapper(genericClassName)) { 
							FieldMeta fieldMeta = field.getAnnotation(FieldMeta.class);
							bw.append("import "+fieldMeta.associatedSourceClass().getName()+";\n");
							bw.append("import "+packageElement.getQualifiedName()+"."+genericClassName+";\n");
						}
					}
				 }
				bw.newLine();
				bw.newLine();

				bw.append("public class " + sourceClassName + "Mapper {\n\n\n");
			    bw.append("public "+dtoName+" mapSourceToDTO("+sourceClassName+ " source) { \n");
			    bw.append(EXTRA_SPACE+dtoName+" "+dtoName.toLowerCase()+" = new "+dtoName+"();\n");
			    for(Field field: fields){ 
			    	Class<?> fieldType = field.getType();
			    	String lookupMethodNameInDTO="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);	
			    	String lookupMethodNameInSource="get"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
			    	if(fieldType.getSimpleName().equals("boolean") || fieldType.getSimpleName().equals("Boolean"))
			    		lookupMethodNameInSource="is"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
			    	Method methodSet = dtoClassInstance.getMethod(lookupMethodNameInDTO, fieldType);
			    	Method methodGet = sourceClassInstance.getMethod(lookupMethodNameInSource);
			    	//System.out.println(methodSet.getName()+"------"+methodGet.getName());
			    	String destinationFieldTypeSimpleName = fieldType.getSimpleName();
			    	String sourceFieldTypeSimpleName = fieldType.getSimpleName().replace("DTO", "");
			    	System.out.println("Simple Name ---"+destinationFieldTypeSimpleName);
			    	
			    	if(fieldType.getSimpleName().equals("List")) {
			    		Type genericType = field.getGenericType();			
			    		String genericClassName = getGenericClassName(genericType);
			    		String genericClassNameSource = genericClassName.replace("DTO", "");
			    		if(checkPrimitiveOrWrapper(genericClassName)) {		 				    		
					    	bw.append(EXTRA_SPACE+dtoName.toLowerCase()+"."+methodSet.getName()+"(source."+methodGet.getName()+"()); \n");
				    	} else {
				    		bw.append(EXTRA_SPACE+genericClassNameSource+"Mapper "+genericClassNameSource.toLowerCase()+"Mapper = new "+genericClassNameSource+"Mapper();\n");
				    		bw.append(EXTRA_SPACE+"List<"+genericClassName+"> "+genericClassName.toLowerCase()+"List = new ArrayList<"+genericClassName+">();\n");
				    		bw.append(EXTRA_SPACE+"for("+genericClassNameSource+" "+genericClassNameSource.toLowerCase() +": source."+methodGet.getName()+"()) { \n");
				    		bw.append(EXTRA_SPACE+EXTRA_SPACE+genericClassName.toLowerCase()+"List.add("+genericClassNameSource.toLowerCase()+"Mapper.mapSourceToDTO("+genericClassNameSource.toLowerCase()+"));\n");
				    		bw.append(EXTRA_SPACE+"}\n");
				    		bw.append(EXTRA_SPACE+dtoName.toLowerCase()+"."+methodSet.getName()+"("+genericClassName.toLowerCase()+"List); \n");
				    	}
			    	}  else {
			    		if(checkPrimitiveOrWrapper(fieldType.getSimpleName())) {		 				    		
					    	bw.append(EXTRA_SPACE+dtoName.toLowerCase()+"."+methodSet.getName()+"(source."+methodGet.getName()+"()); \n");
				    	} else {
				    		bw.append(EXTRA_SPACE+sourceFieldTypeSimpleName+"Mapper "+sourceFieldTypeSimpleName.toLowerCase()+"Mapper = new "+sourceFieldTypeSimpleName+"Mapper();\n");
				    		bw.append(EXTRA_SPACE+dtoName.toLowerCase()+"."+methodSet.getName()+""
				    				+ "("+sourceFieldTypeSimpleName.toLowerCase()+"Mapper.mapSourceToDTO(source."+methodGet.getName()+"())); \n");
				    	}
			    	}	
			    	
			    	
			    	
			    	
			    	
			    	//System.out.println("fieldType-------------"+fieldType.getSimpleName());
			    }
			    bw.append(EXTRA_SPACE+"return "+dtoName.toLowerCase()+";\n");

                bw.append("}\n");
                bw.append("}\n");

				bw.flush();
				bw.close();
				System.out.println(sourceClassName+"Mapper Generated");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return true;
	}

	

	private static TypeMirror getEntity(Relation annotation) {
		try {
			if (annotation instanceof Relation)
				((Relation) annotation).associatedSourceClass(); // this should
																	// throw

		} catch (MirroredTypeException mte) {
			return mte.getTypeMirror();
		}
		return null; // can this ever happen - think , think and think again??
	}

	private TypeElement asTypeElement(TypeMirror typeMirror) {
		Types TypeUtils = this.processingEnv.getTypeUtils();
		return (TypeElement) TypeUtils.asElement(typeMirror);
	}

	private List<Field> getAllFields(Class<?> classInstance) {
		Set<String> fieldNameSet = new HashSet<String>();
		List<Field> fieldList = new ArrayList<Field>();
		for (Field f : classInstance.getDeclaredFields()) {
			fieldNameSet.add(f.getName());
			fieldList.add(f);
		}
		return fieldList;
	}
	
	private boolean checkPrimitiveOrWrapper(String fieldTypeName) {
		return ((fieldTypeName.equals("Integer") || fieldTypeName.equals("int") ||
				fieldTypeName.equals("Double")   || fieldTypeName.equals("double") || 
				fieldTypeName.equals("Short")    || fieldTypeName.equals("short") || 
				fieldTypeName.equals("long")     || fieldTypeName.equals("Long")) ||
				fieldTypeName.equals("boolean") || fieldTypeName.equals("Boolean") ||
				fieldTypeName.equals("String") || fieldTypeName.equals("Date"));
	}
	
	private String getGenericClassName(Type genericType) {
		return genericType.toString().substring(genericType.toString().lastIndexOf(".")+1).replace(">", "");
	}
}
