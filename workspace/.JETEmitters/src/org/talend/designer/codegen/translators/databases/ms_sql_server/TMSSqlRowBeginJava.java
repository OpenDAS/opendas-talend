package org.talend.designer.codegen.translators.databases.ms_sql_server;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMSSqlRowBeginJava
{
  protected static String nl;
  public static synchronized TMSSqlRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMSSqlRowBeginJava result = new TMSSqlRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\tString dbschema_";
  protected final String TEXT_3 = " =\"\";" + NL + "\t";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "\tdbschema_";
  protected final String TEXT_6 = " = (String)globalMap.get(\"";
  protected final String TEXT_7 = "\");" + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_8 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_9 = "\");" + NL + "\t";
  protected final String TEXT_10 = NL + "    dbschema_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "    java.lang.Class.forName(\"net.sourceforge.jtds.jdbc.Driver\");" + NL + "    String port_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "    String dbname_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = " ;" + NL + "    String url_";
  protected final String TEXT_17 = " = \"jdbc:jtds:sqlserver://\" + ";
  protected final String TEXT_18 = " ; " + NL + "    if (!\"\".equals(port_";
  protected final String TEXT_19 = ")) {" + NL + "    \turl_";
  protected final String TEXT_20 = " += \":\" + ";
  protected final String TEXT_21 = ";" + NL + "    }" + NL + "    if (!\"\".equals(dbname_";
  protected final String TEXT_22 = ")) {" + NL + "    \turl_";
  protected final String TEXT_23 = " += \"//\" + ";
  protected final String TEXT_24 = "; " + NL + "    }" + NL + "    url_";
  protected final String TEXT_25 = " += \";appName=\" + projectName + \";\" + ";
  protected final String TEXT_26 = ";" + NL + "    String dbUser_";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_30 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = "; ";
  protected final String TEXT_35 = NL + "    String dbPwd_";
  protected final String TEXT_36 = " = decryptedPassword_";
  protected final String TEXT_37 = ";" + NL + "    java.sql.Connection conn_";
  protected final String TEXT_38 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_39 = ",dbUser_";
  protected final String TEXT_40 = ",dbPwd_";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = NL + "            conn_";
  protected final String TEXT_44 = ".setAutoCommit(false);            " + NL + "            int commitEvery_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";    " + NL + "            int commitCounter_";
  protected final String TEXT_47 = " = 0;    ";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\tjava.sql.PreparedStatement pstmt_";
  protected final String TEXT_50 = " = conn_";
  protected final String TEXT_51 = ".prepareStatement(";
  protected final String TEXT_52 = ");\t";
  protected final String TEXT_53 = NL + "\tjava.sql.Statement stmt_";
  protected final String TEXT_54 = " = conn_";
  protected final String TEXT_55 = ".createStatement();";
  protected final String TEXT_56 = NL + "        String  tableName_";
  protected final String TEXT_57 = " = null;" + NL + "        if(dbschema_";
  protected final String TEXT_58 = " == null || dbschema_";
  protected final String TEXT_59 = ".trim().length() == 0) {" + NL + "            tableName_";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ";" + NL + "        } else {" + NL + "            tableName_";
  protected final String TEXT_62 = " = dbschema_";
  protected final String TEXT_63 = " + \"].[\" + ";
  protected final String TEXT_64 = ";" + NL + "        }" + NL + "        stmt_";
  protected final String TEXT_65 = ".execute(\"SET IDENTITY_INSERT [\"+ tableName_";
  protected final String TEXT_66 = " +\"] ON\");";
  protected final String TEXT_67 = NL + "String query_";
  protected final String TEXT_68 = " = \"\";" + NL + "    boolean whetherReject_";
  protected final String TEXT_69 = " = false;    ";
  protected final String TEXT_70 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
    String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
	       
    	   dbquery = org.talend.core.model.utils.NodeUtil.replaceCRLFInMEMO_SQL(dbquery);
    
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
 	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
    String identityInsert = ElementParameterParser.getValue(node, "__IDENTITY_INSERT__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    
boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
if(useExistingConnection) {
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String conn = "conn_" + connection;
	String schema = "dbschema_" + connection;
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(schema);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_9);
    
} else {       
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_28);
    
    String passwordFieldName = "__PASS__";
    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_31);
    } else {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
}

    stringBuffer.append(TEXT_42);
    
    if(!useExistingConnection) {
        if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    
        }
    }
    
    stringBuffer.append(TEXT_48);
    
	if (usePrepareStatement ) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dbquery);
    stringBuffer.append(TEXT_52);
    
	} else {

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    
	}

    
    if(("true").equals(identityInsert)) {	

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
    }

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    return stringBuffer.toString();
  }
}
