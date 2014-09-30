package org.talend.designer.codegen.translators.databases.maxdb;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;

public class TMaxDBOutputEndJava
{
  protected static String nl;
  public static synchronized TMaxDBOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMaxDBOutputEndJava result = new TMaxDBOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        conn_";
  protected final String TEXT_2 = ".commit();";
  protected final String TEXT_3 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_4 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_5 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_6 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_7 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_8 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_9 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_10 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_11 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_12 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_13 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_14 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_15 = NL + "        if(pstmt_";
  protected final String TEXT_16 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_17 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_18 = NL + "    conn_";
  protected final String TEXT_19 = " .close();" + NL + "    resourceMap.put(\"finish_";
  protected final String TEXT_20 = "\", true);" + NL + "" + NL + "\tnb_line_deleted_";
  protected final String TEXT_21 = "=nb_line_deleted_";
  protected final String TEXT_22 = "+ deletedCount_";
  protected final String TEXT_23 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_24 = "=nb_line_update_";
  protected final String TEXT_25 = " + updatedCount_";
  protected final String TEXT_26 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_27 = "=nb_line_inserted_";
  protected final String TEXT_28 = " + insertedCount_";
  protected final String TEXT_29 = ";";
  protected final String TEXT_30 = NL + "\tif (globalMap.get(\"";
  protected final String TEXT_31 = "_NB_LINE\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_32 = "_NB_LINE\",nb_line_";
  protected final String TEXT_33 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_34 = "_NB_LINE\",(Integer)globalMap.get(\"";
  protected final String TEXT_35 = "_NB_LINE\") + nb_line_";
  protected final String TEXT_36 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_37 = "_NB_LINE_UPDATED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_38 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_39 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_40 = "_NB_LINE_UPDATED\",(Integer)globalMap.get(\"";
  protected final String TEXT_41 = "_NB_LINE_UPDATED\") + nb_line_update_";
  protected final String TEXT_42 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_43 = "_NB_LINE_INSERTED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_44 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_45 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_46 = "_NB_LINE_INSERTED\",(Integer)globalMap.get(\"";
  protected final String TEXT_47 = "_NB_LINE_INSERTED\") + nb_line_inserted_";
  protected final String TEXT_48 = ");" + NL + "    }" + NL + "    if (globalMap.get(\"";
  protected final String TEXT_49 = "_NB_LINE_DELETED\") == null) {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_50 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_51 = ");" + NL + "    } else {" + NL + "    \tglobalMap.put(\"";
  protected final String TEXT_52 = "_NB_LINE_DELETED\",(Integer)globalMap.get(\"";
  protected final String TEXT_53 = "_NB_LINE_DELETED\") + nb_line_deleted_";
  protected final String TEXT_54 = ");" + NL + "    }";
  protected final String TEXT_55 = NL + "    globalMap.put(\"";
  protected final String TEXT_56 = "_NB_LINE\",nb_line_";
  protected final String TEXT_57 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_58 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_59 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_60 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_61 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_62 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");

    if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
        
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
    }	
	
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
    } else {
        
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
    }   
    
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
	boolean isEnableParallelize ="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__PARALLELIZE__"));
	if (isEnableParallelize) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
	} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
	}

    stringBuffer.append(TEXT_64);
    return stringBuffer.toString();
  }
}
