package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.EConnectionType;
import java.util.List;
import java.util.Map;

public class TMDMWriteConfMainJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfMainJava result = new TMDMWriteConfMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "      ";
  protected final String TEXT_4 = " = new ";
  protected final String TEXT_5 = "Struct();";
  protected final String TEXT_6 = NL + "      ";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = " = strXmlField_";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL + "      \t\tjava.util.Map<String,String> xmlFlow_";
  protected final String TEXT_11 = " = xmlFlowList_";
  protected final String TEXT_12 = ".get(flowNum_";
  protected final String TEXT_13 = ");" + NL + "      \t\tString valueStr_";
  protected final String TEXT_14 = ";" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t \t\t\tvalueStr_";
  protected final String TEXT_16 = " = xmlFlow_";
  protected final String TEXT_17 = ".get(\"";
  protected final String TEXT_18 = "\");" + NL + "\t  \t\t\tif (valueStr_";
  protected final String TEXT_19 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = " = valueStr_";
  protected final String TEXT_23 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = ParserUtils.parseTo_Date(valueStr_";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = " = valueStr_";
  protected final String TEXT_32 = ".getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " = ParserUtils.parseTo_";
  protected final String TEXT_36 = "(valueStr_";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = "\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ";" + NL + "\t\t\t\t}" + NL + "\t      \t\t";
  protected final String TEXT_42 = NL + "    input_";
  protected final String TEXT_43 = " = strXmlField_";
  protected final String TEXT_44 = ";" + NL + "" + NL + "    try {" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\t\torg.talend.mdm.webservice.WSPartialPutItem wsPartialPutItem_";
  protected final String TEXT_46 = " = new org.talend.mdm.webservice.WSPartialPutItem(input_";
  protected final String TEXT_47 = ",";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = ",";
  protected final String TEXT_50 = ",";
  protected final String TEXT_51 = ",";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = ");" + NL + "\t\t\twspk_";
  protected final String TEXT_54 = " = xtentisWS_";
  protected final String TEXT_55 = ".partialPutItem(wsPartialPutItem_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t              \t";
  protected final String TEXT_58 = ".";
  protected final String TEXT_59 = "= wspk_";
  protected final String TEXT_60 = ".getIds(";
  protected final String TEXT_61 = ");" + NL + "\t            ";
  protected final String TEXT_62 = "     " + NL + "            " + NL + "\t\t";
  protected final String TEXT_63 = "   " + NL + "\t\t\t" + NL + "\t\t\torg.talend.mdm.webservice.WSPutItem item_";
  protected final String TEXT_64 = " = new org.talend.mdm.webservice.WSPutItem(dataCluster_";
  protected final String TEXT_65 = ",input_";
  protected final String TEXT_66 = ",dataModel_";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ");" + NL + "\t      \t";
  protected final String TEXT_69 = NL + "\t        \torg.talend.mdm.webservice.WSPutItemWithReport itemReport_";
  protected final String TEXT_70 = " = new org.talend.mdm.webservice.WSPutItemWithReport(item_";
  protected final String TEXT_71 = ",";
  protected final String TEXT_72 = ",";
  protected final String TEXT_73 = ");" + NL + "\t\t" + NL + "\t\t        ";
  protected final String TEXT_74 = NL + "\t\t        \t";
  protected final String TEXT_75 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_76 = ".add(";
  protected final String TEXT_77 = ");" + NL + "\t\t        \t";
  protected final String TEXT_78 = NL + "\t\t          miList_";
  protected final String TEXT_79 = ".add(itemReport_";
  protected final String TEXT_80 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_81 = ".size() >= ";
  protected final String TEXT_82 = ") {" + NL + "\t\t            wspks_";
  protected final String TEXT_83 = " = xtentisWS_";
  protected final String TEXT_84 = ".putItemWithReportArray(miList_";
  protected final String TEXT_85 = ".toArray(new org.talend.mdm.webservice.WSPutItemWithReport[";
  protected final String TEXT_86 = "]));" + NL + "\t\t            miList_";
  protected final String TEXT_87 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_88 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_89 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_90 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_91 = ",wspks_";
  protected final String TEXT_92 = "));" + NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_93 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_94 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_95 = NL + "\t\t          wspk_";
  protected final String TEXT_96 = " = xtentisWS_";
  protected final String TEXT_97 = ".putItemWithReport(itemReport_";
  protected final String TEXT_98 = ");" + NL + "\t\t          \t";
  protected final String TEXT_99 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_100 = ".updateItemMetadata(util_";
  protected final String TEXT_101 = ". makeUpdateMeteItm(";
  protected final String TEXT_102 = ",wspk_";
  protected final String TEXT_103 = "));" + NL + "\t\t            ";
  protected final String TEXT_104 = NL + "\t\t        ";
  protected final String TEXT_105 = NL + "\t\t            ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = "= wspk_";
  protected final String TEXT_108 = ".getIds(";
  protected final String TEXT_109 = ");" + NL + "\t\t          ";
  protected final String TEXT_110 = NL + "\t\t        \t";
  protected final String TEXT_111 = NL + "\t\t        \t\ttaskIDs_";
  protected final String TEXT_112 = ".add(";
  protected final String TEXT_113 = ");" + NL + "\t\t        \t";
  protected final String TEXT_114 = NL + "\t\t          miList_";
  protected final String TEXT_115 = ".add(item_";
  protected final String TEXT_116 = ");" + NL + "\t\t" + NL + "\t\t          if (miList_";
  protected final String TEXT_117 = ".size() >= ";
  protected final String TEXT_118 = ") {" + NL + "\t\t            wspks_";
  protected final String TEXT_119 = " = xtentisWS_";
  protected final String TEXT_120 = ".putItemArray(miList_";
  protected final String TEXT_121 = ".toArray(new org.talend.mdm.webservice.WSPutItem[";
  protected final String TEXT_122 = "]));" + NL + "\t\t            miList_";
  protected final String TEXT_123 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_124 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_125 = ".updateItemArrayMetadata(util_";
  protected final String TEXT_126 = ". makeUpdateMeteItms(taskIDs_";
  protected final String TEXT_127 = ",wspks_";
  protected final String TEXT_128 = "));" + NL + "\t\t            \ttaskIDs_";
  protected final String TEXT_129 = ".clear();" + NL + "\t\t            ";
  protected final String TEXT_130 = NL + "\t\t          }" + NL + "\t\t        ";
  protected final String TEXT_131 = NL + "\t\t          wspk_";
  protected final String TEXT_132 = " = xtentisWS_";
  protected final String TEXT_133 = ".putItem(item_";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t            \txtentisWS_";
  protected final String TEXT_136 = ".updateItemMetadata(util_";
  protected final String TEXT_137 = ". makeUpdateMeteItm(";
  protected final String TEXT_138 = ",wspk_";
  protected final String TEXT_139 = "));" + NL + "\t\t            ";
  protected final String TEXT_140 = NL + "\t\t          ";
  protected final String TEXT_141 = NL + "\t\t              ";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = "= wspk_";
  protected final String TEXT_144 = ".getIds(";
  protected final String TEXT_145 = ");" + NL + "\t\t            ";
  protected final String TEXT_146 = NL + "\t    ";
  protected final String TEXT_147 = "  " + NL + "    } catch (Exception e) {";
  protected final String TEXT_148 = NL + "        throw(e);";
  protected final String TEXT_149 = NL + "            ";
  protected final String TEXT_150 = " = null;";
  protected final String TEXT_151 = NL + "          ";
  protected final String TEXT_152 = " = new ";
  protected final String TEXT_153 = "Struct();" + NL + "          ";
  protected final String TEXT_154 = NL + "      \t\tjava.util.Map<String,String> rejectXmlFlow_";
  protected final String TEXT_155 = " = xmlFlowList_";
  protected final String TEXT_156 = ".get(flowNum_";
  protected final String TEXT_157 = ");" + NL + "      \t\tString rejectValueStr_";
  protected final String TEXT_158 = ";" + NL + "\t\t\t";
  protected final String TEXT_159 = NL + "\t \t\t\trejectValueStr_";
  protected final String TEXT_160 = " = rejectXmlFlow_";
  protected final String TEXT_161 = ".get(\"";
  protected final String TEXT_162 = "\");" + NL + "\t  \t\t\tif (rejectValueStr_";
  protected final String TEXT_163 = " != null){" + NL + "\t\t\t\t\t";
  protected final String TEXT_164 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_165 = ".";
  protected final String TEXT_166 = " = rejectValueStr_";
  protected final String TEXT_167 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_169 = ".";
  protected final String TEXT_170 = " = ParserUtils.parseTo_Date(rejectValueStr_";
  protected final String TEXT_171 = ", ";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = " = rejectValueStr_";
  protected final String TEXT_176 = ".getBytes();" + NL + "\t\t\t\t\t";
  protected final String TEXT_177 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = " = ParserUtils.parseTo_";
  protected final String TEXT_180 = "(rejectValueStr_";
  protected final String TEXT_181 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = "\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\t";
  protected final String TEXT_183 = ".";
  protected final String TEXT_184 = " = ";
  protected final String TEXT_185 = ";" + NL + "\t\t\t\t}" + NL + "\t      \t\t";
  protected final String TEXT_186 = NL + "          ";
  protected final String TEXT_187 = NL + "          ";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " = strXmlField_";
  protected final String TEXT_190 = ";";
  protected final String TEXT_191 = NL + "          ";
  protected final String TEXT_192 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_193 = ";";
  protected final String TEXT_194 = NL + "          System.err.println(e.getMessage());";
  protected final String TEXT_195 = NL + "    }";
  protected final String TEXT_196 = NL + "    flowNum_";
  protected final String TEXT_197 = "++;";
  protected final String TEXT_198 = NL + "    nb_line_";
  protected final String TEXT_199 = "++;";
  protected final String TEXT_200 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
String xmlField = ElementParameterParser.getValue(node,"__XMLFIELD__");
String needCheck = ElementParameterParser.getValue(node,"__ISINVOKE__");
boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
String numMassInsert = ElementParameterParser.getValue(node,"__COMMIT_LEVEL__");
String sourceName = ElementParameterParser.getValue(node,"__SOURCE__");
boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
String isUpdate = ElementParameterParser.getValue(node,"__ISUPDATE__");
List<Map<String,String>> keysReturn = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__RETURN_IDS__");

boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
String taskID = ElementParameterParser.getValue(node,"__TASKID__");

boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));
String pivot = ElementParameterParser.getValue(node,"__PIVOT__");
boolean overwrite = ("true").equals(ElementParameterParser.getValue(node,"__OVERWRITE__"));
String key = ElementParameterParser.getValue(node,"__KEY__");
String position = ElementParameterParser.getValue(node,"__POSITION__");
String dataModule = ElementParameterParser.getValue(node, "__DATAMODEL__");
String dataCluster = ElementParameterParser.getValue(node, "__DATACLUSTER__");

boolean storeFlow = ("true").equals(ElementParameterParser.getValue(node, "__STORE_FLOW__"));

List<IMetadataTable> metadatas = node.getMetadataList();

if (destination != null && !"".equals(destination)) {
  cid = destination;
}

if (metadatas != null && metadatas.size()>0) { 
  IMetadataTable metadata = metadatas.get(0);
  if (metadata != null) { 
  
  	List<? extends IConnection> outputConns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
  	List<IMetadataColumn> outputColumnList = null;
  	if (outputConns != null && outputConns.size() > 0) {
	  	IConnection outputConn = outputConns.get(0);
	  	if(outputConn!=null){
		  	IMetadataTable outputMetadata = outputConn.getMetadataTable();
		  	if(outputMetadata!=null){
		  		outputColumnList = outputMetadata.getListColumns();
		  	}
	  	}
  	}
  	
    String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    List<IMetadataColumn> rejectColumnList = null;
    if (rejectConns != null && rejectConns.size() > 0) {
      IConnection rejectConn = rejectConns.get(0);
      if(rejectConn!=null){
      	rejectConnName = rejectConn.getName();
      	IMetadataTable metadataTable = rejectConn.getMetadataTable();
      	if(metadataTable!=null){
      		rejectColumnList = metadataTable.getListColumns();
      	}
      }
    }
   
    String outConnName = null;
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();

    for(IConnection tmpconn : outgoingConns) {
      if (tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        if(rejectConnName==null || !rejectConnName.equals(tmpconn.getName())){
          outConnName=tmpconn.getName();
        }
    stringBuffer.append(TEXT_1);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_2);
    
      }
    }

    if (outConnName != null) {
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(storeFlow){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
			if(outputColumnList!=null){
				for( int i = 0; i < outputColumnList.size(); i++) {
					IMetadataColumn column = outputColumnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(xmlField.equals(column.getLabel())){
						continue;
					}
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
					if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
					
    stringBuffer.append(TEXT_20);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date
					
    stringBuffer.append(TEXT_24);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_28);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
					
    stringBuffer.append(TEXT_29);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
					} else  { // other
					
    stringBuffer.append(TEXT_33);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_35);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
					}
					
    stringBuffer.append(TEXT_38);
    stringBuffer.append(outConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_41);
    }
	      	}
      }
    }
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    if(usePartialUpdate && !withReport){ // partial
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(dataCluster );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(pivot);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(dataModule );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(key.equals("")?null:key);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(position.equals("")?null:position);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(overwrite);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
	        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
	        	for (int i = 0; i < keysReturn.size(); i++){
	            	Map<String,String> map = keysReturn.get(i);
	              	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_61);
    
	            }
	       	}
		   	
    stringBuffer.append(TEXT_62);
    }else{// not partial 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(isUpdate );
    stringBuffer.append(TEXT_68);
    
		    if (withReport) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(sourceName );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(needCheck );
    stringBuffer.append(TEXT_73);
    if (isMassInsert) {
    stringBuffer.append(TEXT_74);
    if(addTaskID){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(taskID);
    stringBuffer.append(TEXT_77);
    }
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    if(addTaskID){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(TEXT_94);
    } else {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    if(addTaskID){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(taskID);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    
		        }
		
		        if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		        
		          for (int i = 0; i < keysReturn.size(); i++){
		            Map<String,String> map = keysReturn.get(i);
		            
    stringBuffer.append(TEXT_105);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_109);
    
		          }
		        }
		      } else {
		      
		        if (isMassInsert) {
		        
    stringBuffer.append(TEXT_110);
    if(addTaskID){
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(taskID);
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(numMassInsert );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    if(addTaskID){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    
		        } else {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    if(addTaskID){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(taskID);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    
		          if (outConnName !=null && !isMassInsert && keysReturn.size() > 0) {
		            for (int i = 0; i < keysReturn.size(); i++){
		              Map<String,String> map = keysReturn.get(i);
		              
    stringBuffer.append(TEXT_141);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(map.get("OUTPUT_COLUMN"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_145);
    
		            }
		          }
		        }
		      }
		      
    stringBuffer.append(TEXT_146);
    }//end partial
    stringBuffer.append(TEXT_147);
    if (dieOnError) {
    stringBuffer.append(TEXT_148);
    } else {

        if (rejectConnName != null) {
          if (outConnName != null) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(outConnName );
    stringBuffer.append(TEXT_150);
    }
    stringBuffer.append(TEXT_151);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_153);
    if(storeFlow){
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    
			if(rejectColumnList!=null){
				for( int i = 0; i < rejectColumnList.size(); i++) {
					IMetadataColumn column = rejectColumnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(xmlField.equals(column.getLabel())){
						continue;
					}
				
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
					if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object
					
    stringBuffer.append(TEXT_164);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date
					
    stringBuffer.append(TEXT_168);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_172);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]
					
    stringBuffer.append(TEXT_173);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
					} else  { // other
					
    stringBuffer.append(TEXT_177);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_179);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    
					}
					
    stringBuffer.append(TEXT_182);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_185);
    }
	      	}
      	  }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(xmlField );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_193);
    } else {
    stringBuffer.append(TEXT_194);
    }
      }
    stringBuffer.append(TEXT_195);
    if(storeFlow){
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    
  }
}
    stringBuffer.append(TEXT_200);
    return stringBuffer.toString();
  }
}