package org.talend.designer.codegen.translators.databases.teradata;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.MappingTypeRetriever;
import org.talend.core.model.metadata.MetadataTalendType;
import java.util.List;
import java.lang.StringBuilder;
import java.util.Map;

public class TTeradataFastLoadUtilityMainJava
{
  protected static String nl;
  public static synchronized TTeradataFastLoadUtilityMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TTeradataFastLoadUtilityMainJava result = new TTeradataFastLoadUtilityMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "String tableFullName_";
  protected final String TEXT_2 = " = ";
  protected final String TEXT_3 = " + \".\" + ";
  protected final String TEXT_4 = ";" + NL + "java.io.FileWriter fw_";
  protected final String TEXT_5 = " = new java.io.FileWriter(";
  protected final String TEXT_6 = "+";
  protected final String TEXT_7 = "+\".script\");" + NL;
  protected final String TEXT_8 = NL + NL + "StringBuilder script_";
  protected final String TEXT_9 = " = new StringBuilder();" + NL + "fw_";
  protected final String TEXT_10 = ".write(\"SESSIONS 8;\\r\\n\");" + NL + "fw_";
  protected final String TEXT_11 = ".write(\"SET RECORD VARTEXT \\\"\"+";
  protected final String TEXT_12 = "+\"\\\";\\r\\n\");" + NL + "fw_";
  protected final String TEXT_13 = ".write(\"LOGON \"+";
  protected final String TEXT_14 = "+\",\"+";
  protected final String TEXT_15 = "+\";\\r\\n\");";
  protected final String TEXT_16 = NL + "fw_";
  protected final String TEXT_17 = ".write(\"DELETE FROM \"+ ";
  protected final String TEXT_18 = " + \".\" + ";
  protected final String TEXT_19 = " + \" ALL;\\r\\n\");";
  protected final String TEXT_20 = NL + "fw_";
  protected final String TEXT_21 = ".write(\"DEFINE \\r\\n\");";
  protected final String TEXT_22 = NL + "\t\tfw_";
  protected final String TEXT_23 = ".write(\"";
  protected final String TEXT_24 = "\"+\" (VARCHAR(";
  protected final String TEXT_25 = ")),\\r\\n\");" + NL + "\t";
  protected final String TEXT_26 = NL + "\t\t\tfw_";
  protected final String TEXT_27 = ".write(\"";
  protected final String TEXT_28 = "\"+\" (VARCHAR(";
  protected final String TEXT_29 = "))\\r\\n\");" + NL + "\t";
  protected final String TEXT_30 = NL + "fw_";
  protected final String TEXT_31 = ".write(\"FILE=\"+";
  protected final String TEXT_32 = "+\";\\r\\n\");" + NL + "fw_";
  protected final String TEXT_33 = ".write(\"BEGIN LOADING \"+ ";
  protected final String TEXT_34 = " + \".\" + ";
  protected final String TEXT_35 = "+\" \"+";
  protected final String TEXT_36 = "+\" CHECKPOINT ";
  protected final String TEXT_37 = ";\\r\\n\");" + NL + "fw_";
  protected final String TEXT_38 = ".write(\"ERRLIMIT ";
  protected final String TEXT_39 = ";\\r\\n\");";
  protected final String TEXT_40 = NL + "fw_";
  protected final String TEXT_41 = ".write(\"INSERT INTO \"+ ";
  protected final String TEXT_42 = " + \".\" + ";
  protected final String TEXT_43 = "+\" (";
  protected final String TEXT_44 = ") VALUES (";
  protected final String TEXT_45 = ");\\r\\n\");";
  protected final String TEXT_46 = NL + "fw_";
  protected final String TEXT_47 = ".write(\"END LOADING;\\r\\n\");" + NL + "fw_";
  protected final String TEXT_48 = ".write(\"LOGOFF;\\r\\n\");" + NL;
  protected final String TEXT_49 = NL + "fw_";
  protected final String TEXT_50 = ".close();" + NL;
  protected final String TEXT_51 = NL + "String sb_";
  protected final String TEXT_52 = "= new String(\"";
  protected final String TEXT_53 = "fastload -c \"+";
  protected final String TEXT_54 = "+\" < \\\"\"+";
  protected final String TEXT_55 = "+";
  protected final String TEXT_56 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_57 = "+\"\\\" 2>&1\");";
  protected final String TEXT_58 = "\t" + NL + "String sb_";
  protected final String TEXT_59 = "= new String(\"";
  protected final String TEXT_60 = "fastload < \\\"\"+";
  protected final String TEXT_61 = "+";
  protected final String TEXT_62 = "+\".script\\\" > \\\"\"+";
  protected final String TEXT_63 = "+\"\\\" 2>&1\");";
  protected final String TEXT_64 = NL + "final Process process_";
  protected final String TEXT_65 = " = Runtime.getRuntime().exec(sb_";
  protected final String TEXT_66 = "); " + NL + "Thread normal_";
  protected final String TEXT_67 = " = new Thread() {" + NL + "    public void run() {" + NL + "    \ttry {" + NL + "    \t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_68 = ".getInputStream()));" + NL + "    \t\tString line = \"\";" + NL + "    \t\ttry {" + NL + "    \t\t\twhile((line = reader.readLine()) != null) {" + NL + "    \t\t\t   System.out.println(line);" + NL + "    \t        }" + NL + "    \t    } finally {" + NL + "    \t         reader.close();" + NL + "    \t    }" + NL + "        }catch(java.io.IOException ioe) {" + NL + "    \t\tioe.printStackTrace();" + NL + "    \t}" + NL + "    }" + NL + "};" + NL + "normal_";
  protected final String TEXT_69 = ".start();" + NL + "" + NL + "Thread error_";
  protected final String TEXT_70 = " = new Thread() {" + NL + "\tpublic void run() {" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process_";
  protected final String TEXT_71 = ".getErrorStream()));" + NL + "\t\t\tString line = \"\";" + NL + "\t\t\ttry {" + NL + "\t\t\t\twhile((line = reader.readLine()) != null) {" + NL + "\t\t\t\t\tSystem.err.println(line);" + NL + "\t\t\t\t}" + NL + "\t\t\t} finally {" + NL + "\t\t\t\treader.close();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.io.IOException ioe) {" + NL + "\t\t   ioe.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "};" + NL + "error_";
  protected final String TEXT_72 = ".start();" + NL + "" + NL + "process_";
  protected final String TEXT_73 = ".waitFor();" + NL + "" + NL + "normal_";
  protected final String TEXT_74 = ".interrupt();" + NL + "" + NL + "error_";
  protected final String TEXT_75 = ".interrupt();" + NL + "" + NL + "globalMap.put(\"";
  protected final String TEXT_76 = "_EXIT_VALUE\", process_";
  protected final String TEXT_77 = ".exitValue());" + NL;
  protected final String TEXT_78 = NL + "\tif(process_";
  protected final String TEXT_79 = ".exitValue()>=";
  protected final String TEXT_80 = ") {" + NL + "\t\tthrow new RuntimeException(\"Fastload returned exit code \"+process_";
  protected final String TEXT_81 = ".exitValue());" + NL + "\t}";
  protected final String TEXT_82 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser= ElementParameterParser.getValue(node, "__USER__");
String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
String table= ElementParameterParser.getValue(node, "__TABLE__");

String scriptPath= ElementParameterParser.getValue(node, "__SCRIPT_PATH__");
String execution= ElementParameterParser.getValue(node, "__EXECUTION__");
String loadFile= ElementParameterParser.getValue(node, "__LOAD_FILE__");
String separator= ElementParameterParser.getValue(node, "__FIELD_SEPARATOR__");
String errorFile= ElementParameterParser.getValue(node, "__ERROR_FILE__");

boolean returnCodeDie= ElementParameterParser.getValue(node, "__RETURN_CODE_DIE__").equals("true");
String returnCode= ElementParameterParser.getValue(node, "__RETURN_CODE__");

String checkPoint= ElementParameterParser.getValue(node, "__CHECK_POINT__");

String errorFiles= ElementParameterParser.getValue(node, "__ERRORFILES__");

String defineCharset = ElementParameterParser.getValue(node, "__DEFINE_CHARSET__");
String charset = ElementParameterParser.getValue(node, "__CHARSET__");

String errLimit = ElementParameterParser.getValue(node, "__ERRLIMIT__");

String tableAction = ElementParameterParser.getValue(node,"__TABLE_ACTION__");

if(!scriptPath.endsWith("/\"")){
	scriptPath = scriptPath+	"+\"/\"";
}
if(loadFile.indexOf("/") !=0 && ("Windows").equals(execution)){
	loadFile = loadFile.replaceAll("/", "\\\\\\\\");
}

String dbmsId = "teradata_id";

List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_7);
    //build script---------------------------------------------------------
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(separator);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_15);
    
if(("CLEAR").equals(tableAction)){

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_19);
    
}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    //Layout---------------------------------------------------------------
    
if(columnList!=null){
	int counter = 1;
	for(IMetadataColumn column:columnList){	
		if( columnList.size() != counter){	
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_25);
    
		} else {
	
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getOriginalDbColumnName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLength() == null ? 0 : column.getLength());
    stringBuffer.append(TEXT_29);
     	}
		counter++;
	}
}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(loadFile);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(errorFiles);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(checkPoint);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(errLimit);
    stringBuffer.append(TEXT_39);
    //SQL statements-------------------------------------------------------
    
StringBuilder insertColSQL = new StringBuilder();
StringBuilder insertValueSQL = new StringBuilder();
if(columnList!=null){
	String columnName = "";
 	for(IMetadataColumn column:columnList){	
 		columnName= column.getOriginalDbColumnName();
 		if(insertColSQL.length()>0){
 			insertColSQL.append(",");
 		}
 		insertColSQL.append(columnName);
 		
 		if(insertValueSQL.length()>0){
 			insertValueSQL.append(",");
 		}
 		insertValueSQL.append(":").append(columnName);
	}
}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(insertColSQL.toString());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(insertValueSQL.toString());
    stringBuffer.append(TEXT_45);
    //Import file----------------------------------------------------------
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    //write script to file-------------------------------------------------
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    //run fastload command----------------------------------------------------
    if("true".equals(defineCharset)) {
	if(!("".equals(charset))) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append((("Windows").equals(execution))?"cmd /c ":"");
    stringBuffer.append(TEXT_53);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_57);
    }} else {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append((("Windows").equals(execution))?"cmd /c ":"");
    stringBuffer.append(TEXT_60);
    stringBuffer.append(scriptPath);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(table);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(errorFile);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    
if(returnCodeDie) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(returnCode);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    	
}

    stringBuffer.append(TEXT_82);
    return stringBuffer.toString();
  }
}