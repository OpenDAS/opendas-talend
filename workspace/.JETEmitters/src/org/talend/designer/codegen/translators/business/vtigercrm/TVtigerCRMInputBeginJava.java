package org.talend.designer.codegen.translators.business.vtigercrm;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TVtigerCRMInputBeginJava
{
  protected static String nl;
  public static synchronized TVtigerCRMInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TVtigerCRMInputBeginJava result = new TVtigerCRMInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_2 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = "; ";
  protected final String TEXT_7 = NL + "    " + NL + "    org.talend.vtiger.IVtigerManager vtigerManager_";
  protected final String TEXT_8 = " = new org.talend.vtiger.VtigerManager(";
  protected final String TEXT_9 = ", decryptedPassword_";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ", ";
  protected final String TEXT_12 = ", ";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = ");" + NL + "    ";
  protected final String TEXT_15 = NL + "                    org.talend.vtiger.module.outlook.Contactdetail [] details_";
  protected final String TEXT_16 = " =  vtigerManager_";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = "();";
  protected final String TEXT_19 = NL + "                    org.talend.vtiger.module.outlook.Taskdetail [] details_";
  protected final String TEXT_20 = " = vtigerManager_";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = "();                ";
  protected final String TEXT_23 = NL + "                    org.talend.vtiger.module.outlook.Clndrdetail [] details_";
  protected final String TEXT_24 = " = vtigerManager_";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = "();";
  protected final String TEXT_27 = NL + "                    org.talend.vtiger.module.customerportal.Kbase_detail [] details_";
  protected final String TEXT_28 = " = vtigerManager_";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = "();";
  protected final String TEXT_31 = NL + "                for(int i_";
  protected final String TEXT_32 = " = 0 ; i_";
  protected final String TEXT_33 = " < details_";
  protected final String TEXT_34 = ".length ; i_";
  protected final String TEXT_35 = "++) {";
  protected final String TEXT_36 = NL + "                            ";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = " = details_";
  protected final String TEXT_39 = "[i_";
  protected final String TEXT_40 = "].get";
  protected final String TEXT_41 = "();";
  protected final String TEXT_42 = NL + "                            ";
  protected final String TEXT_43 = ".";
  protected final String TEXT_44 = " = details_";
  protected final String TEXT_45 = "[i_";
  protected final String TEXT_46 = "];";
  protected final String TEXT_47 = NL + "                //}";
  protected final String TEXT_48 = NL + "                    ";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = vtigerManager_";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "();";
  protected final String TEXT_53 = NL + "\tint nb_line_";
  protected final String TEXT_54 = " = 0;";
  protected final String TEXT_55 = NL + " \t\tcom.vtiger.vtwsclib.WSClient vtMgr_";
  protected final String TEXT_56 = " = new com.vtiger.vtwsclib.WSClient(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_59 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = ";
  protected final String TEXT_63 = "; ";
  protected final String TEXT_64 = NL + "\t\t \t\t" + NL + "\t    boolean lr_";
  protected final String TEXT_65 = " = vtMgr_";
  protected final String TEXT_66 = ".doLogin(";
  protected final String TEXT_67 = ", decryptedPassword_";
  protected final String TEXT_68 = ");" + NL + "\t    if(!lr_";
  protected final String TEXT_69 = "){" + NL + "\t    \tthrow new RuntimeException(vtMgr_";
  protected final String TEXT_70 = ".lastError()==null?\"Login failure, please check the Username&Access Key is correct\":vtMgr_";
  protected final String TEXT_71 = ".lastError().toString());" + NL + "\t    }";
  protected final String TEXT_72 = NL + "\t\torg.json.simple.JSONArray qr_";
  protected final String TEXT_73 = " = vtMgr_";
  protected final String TEXT_74 = ".doQuery(";
  protected final String TEXT_75 = ");" + NL + "\t\tif(vtMgr_";
  protected final String TEXT_76 = ".hasError(qr_";
  protected final String TEXT_77 = ")){" + NL + "\t    \tthrow new RuntimeException(vtMgr_";
  protected final String TEXT_78 = ".lastError()==null? \"No response from vtigerCRM\": vtMgr_";
  protected final String TEXT_79 = ".lastError().toString());" + NL + "\t    }" + NL + "\t\tjava.util.Iterator qrIterator_";
  protected final String TEXT_80 = " = qr_";
  protected final String TEXT_81 = ".iterator();" + NL + "" + NL + "\t\twhile (qrIterator_";
  protected final String TEXT_82 = ".hasNext()) {" + NL + "" + NL + "\t\t    org.json.simple.JSONObject row_";
  protected final String TEXT_83 = " = (org.json.simple.JSONObject) qrIterator_";
  protected final String TEXT_84 = ".next();" + NL + "\t\t\tnb_line_";
  protected final String TEXT_85 = " ++;" + NL + "\t\t    Object value_";
  protected final String TEXT_86 = " = null;";
  protected final String TEXT_87 = "\t\t\t\t\t\t" + NL + "\t\t\t// Get the real value according the columnName" + NL + "\t\t\tvalue_";
  protected final String TEXT_88 = " = row_";
  protected final String TEXT_89 = ".get(\"";
  protected final String TEXT_90 = "\");" + NL + "\t\t\tif (value_";
  protected final String TEXT_91 = " != null && !\"\".equals(value_";
  protected final String TEXT_92 = ".toString())){" + NL + "\t\t\t    String valueStr_";
  protected final String TEXT_93 = " = (String) value_";
  protected final String TEXT_94 = ";";
  protected final String TEXT_95 = NL + "\t\t\t\t";
  protected final String TEXT_96 = ".";
  protected final String TEXT_97 = " = valueStr_";
  protected final String TEXT_98 = ";";
  protected final String TEXT_99 = NL + "\t\t\t\t";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " = ParserUtils.parseTo_Date(valueStr_";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\t\t\t";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = valueStr_";
  protected final String TEXT_107 = ".getBytes();";
  protected final String TEXT_108 = "\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = ParserUtils.parseTo_";
  protected final String TEXT_111 = "(valueStr_";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = "\t\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = " = ";
  protected final String TEXT_116 = ";" + NL + "\t\t\t}";
  protected final String TEXT_117 = NL + NL + NL + NL;
  protected final String TEXT_118 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String version_selection = ElementParameterParser.getValue(node, "__VERSION_SELECTION__");
if(version_selection.equals("VTIGER_50")){

    String serverAddr = ElementParameterParser.getValue(node, "__SERVERADDR__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
    String vtigerPath = ElementParameterParser.getValue(node, "__VTIGERPATH__");
    String userName = ElementParameterParser.getValue(node, "__USERNAME__");
    String version = ElementParameterParser.getValue(node, "__VERSION__");
    String method = ElementParameterParser.getValue(node, "__METHODNAME__");
    String outgoingConnName = null;
    List<? extends IConnection> conns = node.getOutgoingSortedConnections();
    if(conns != null && conns.size() > 0) {
        IConnection conn = conns.get(0);
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
        	outgoingConnName = conn.getName();
        }
    }
    List<IMetadataColumn> metadataColumns = null;
    List<IMetadataTable> metadataTables = node.getMetadataList();
    
    
    String passwordFieldName = "__PASSWORD__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_3);
    } else {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(serverAddr);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(vtigerPath);
    stringBuffer.append(TEXT_14);
    
    if(metadataTables != null && metadataTables.size() > 0) {
        IMetadataTable metadataTable = metadataTables.get(0);
        if(metadataTable != null) {
            metadataColumns = metadataTable.getListColumns();
            if(("searchContactsByEmail").equals(method) || ("getContacts").equals(method) || ("getTasks").equals(method) || ("getClndr").equals(method) || ("get_KBase_details").equals(method)) {
                if(("searchContactsByEmail").equals(method) || ("getContacts").equals(method)) {
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_18);
    
                } else if(("getTasks").equals(method)) {
                    
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_22);
    
                } else if(("getClndr").equals(method)) {
                    
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_26);
    
                } else if(("get_KBase_details").equals(method)) {
                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_30);
    
                }
                
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
                    for(IMetadataColumn metadataColumn : metadataColumns) {
                      if(outgoingConnName!=null){
                        if(("searchContactsByEmail").equals(method) || ("getContacts").equals(method) || ("getTasks").equals(method) || ("getClndr").equals(method)) {
                            
    stringBuffer.append(TEXT_36);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(metadataColumn.getLabel().substring(0,1).toUpperCase());
    stringBuffer.append(metadataColumn.getLabel().substring(1));
    stringBuffer.append(TEXT_41);
    
                        } else if(("get_KBase_details").equals(method)) {
                            
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
                        }
                      }
                    }
                    
    stringBuffer.append(TEXT_47);
    
            } else {
                for(IMetadataColumn metadataColumn : metadataColumns) {
                	if(outgoingConnName!=null){
                    
    stringBuffer.append(TEXT_48);
    stringBuffer.append(outgoingConnName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(metadataColumn.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_52);
    
                    }
                }
            }
        }
    }	    
//*****************************************************version 5.1 start**************************************
}else{ 

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas != null) && (metadatas.size() > 0)) {
        IMetadataTable metadata = metadatas.get(0);
    	
        if (metadata != null) {
    	List<IMetadataColumn> columnList = metadata.getListColumns();
    	int nbSchemaColumns = columnList.size();			
    	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    					
    	// If output columns are defined
    	if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0) {
    	    String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
    	    String username = ElementParameterParser.getValue(node, "__USERNAME_510__");

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_57);
    
            String passwordFieldName = "__ACCESS_KEY__";
            
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    			
    	    boolean bIsManualQuery = ("true").equals(ElementParameterParser.getValue(node, "__MANUAL_QUERY__"));
    	    String sql = "";
    
    	    // Build the request SQL
    	    if (bIsManualQuery){
        		sql = ElementParameterParser.getValue(node, "__QUERY__");
        		sql = sql.replaceAll("\n", " ").replaceAll("\r", " ");
    	    } else{
        		String modulename = ElementParameterParser.getValue(node, "__MODULENAME_510__").trim();
        		String condition = ElementParameterParser.getValue(node, "__CONDITION__").trim();
        
        		StringBuilder sb = new StringBuilder("\"select ");
        		for (IMetadataColumn column: columnList){
        		    sb.append(column.getLabel());
        		    sb.append(",");
        		}
        		sb.deleteCharAt(sb.lastIndexOf(","));
        		sb.append(" from ").append(modulename);
        		if (condition !=null && condition.length() > 3){
        		    sb.append(" where ").append(condition.substring(1, condition.length() - 1));
        		}
        		sb.append("\"");
        		sql = sb.toString();
    	    }
    
    	    IConnection outgoingConn = outgoingConns.get(0);
    	    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) || outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.USE_ITERATE)) { // start 1

    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(sql );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
			  if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    		    for( int i = 0; i < columnList.size(); i++) {
        			IMetadataColumn column = columnList.get(i);
        							
        			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
        							
        			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
        							
        			String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
				    if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) { // String or Object

    stringBuffer.append(TEXT_95);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
				    } else if (javaType == JavaTypesManager.DATE) { // Date

    stringBuffer.append(TEXT_99);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_103);
    
				    } else if (javaType == JavaTypesManager.BYTE_ARRAY) { // byte[]

    stringBuffer.append(TEXT_104);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
				    } else  { // other

    stringBuffer.append(TEXT_108);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
				    }

    stringBuffer.append(TEXT_113);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(columnList.get(i).getLabel());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_116);
    
			    }
			  }
		    }
		}
   	 	}
	}

    
}// version 5.1.0 end

    stringBuffer.append(TEXT_117);
    stringBuffer.append(TEXT_118);
    return stringBuffer.toString();
  }
}
