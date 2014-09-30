package org.talend.designer.codegen.translators.databases.access;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TAccessConnectionBeginJava
{
  protected static String nl;
  public static synchronized TAccessConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAccessConnectionBeginJava result = new TAccessConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_3 = "\");";
  protected final String TEXT_4 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_7 = " = SharedDBConnection.getDBConnection(\"";
  protected final String TEXT_8 = "\",url_";
  protected final String TEXT_9 = ",userName_";
  protected final String TEXT_10 = " , password_";
  protected final String TEXT_11 = " , sharedConnectionName_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\tconn_";
  protected final String TEXT_14 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_15 = ",userName_";
  protected final String TEXT_16 = ",password_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\tconn_";
  protected final String TEXT_19 = ".setAutoCommit(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t            String url_";
  protected final String TEXT_22 = " = \"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=\" + ";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "\t            String url_";
  protected final String TEXT_25 = " = \"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=\" + ";
  protected final String TEXT_26 = ";            ";
  protected final String TEXT_27 = NL + "\t\t\tconn_";
  protected final String TEXT_28 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_29 = ",userName_";
  protected final String TEXT_30 = ",password_";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + "\t\t\tString atnParams_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";" + NL + "\t\t\tatnParams_";
  protected final String TEXT_35 = " = atnParams_";
  protected final String TEXT_36 = ".replaceAll(\"&\", \"\\n\");" + NL + "\t\t\tjava.util.Properties atnParamsPrope_";
  protected final String TEXT_37 = " = new java.util.Properties();" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_38 = ".put(\"user\",userName_";
  protected final String TEXT_39 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_40 = ".put(\"password\",password_";
  protected final String TEXT_41 = ");" + NL + "\t\t\tatnParamsPrope_";
  protected final String TEXT_42 = ".load(new java.io.ByteArrayInputStream(atnParams_";
  protected final String TEXT_43 = ".getBytes()));" + NL + "\t\t\tconn_";
  protected final String TEXT_44 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_45 = ", atnParamsPrope_";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + NL + "\t";
  protected final String TEXT_48 = NL + NL + "\tString userName_";
  protected final String TEXT_49 = " = ";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL + "\t";
  protected final String TEXT_52 = NL + "\t\tString password_";
  protected final String TEXT_53 = " = \"null\";" + NL + "\t";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_56 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_59 = " = ";
  protected final String TEXT_60 = "; ";
  protected final String TEXT_61 = NL + "\t\tString password_";
  protected final String TEXT_62 = " = decryptedPassword_";
  protected final String TEXT_63 = ";" + NL + "\t";
  protected final String TEXT_64 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_65 = " = null;" + NL;
  protected final String TEXT_66 = NL + "\t";
  protected final String TEXT_67 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_68 = ")) {";
  protected final String TEXT_69 = NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t";
  protected final String TEXT_71 = NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_72 = "\", conn_";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t}";
  protected final String TEXT_75 = NL + "\tif (null != conn_";
  protected final String TEXT_76 = ") {" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\tglobalMap.put(\"conn_\" + \"";
  protected final String TEXT_79 = "\",conn_";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	class DefaultConnectionUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    
	    public void beforeComponentProcess(INode node){
	    }
	    
		public void createURL(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
		}
		
		public String getDirverClassName(INode node){
			return "";
		}
		
		public void classForName(INode node){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_3);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_20);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
	class ConnectionUtil extends DefaultConnectionUtil{
	
		public void createURL(INode node) {
			super.createURL(node);
			String dbversion = ElementParameterParser.getValue(node, "__DB_VERSION__");

    			
			if ("Access_2003".equalsIgnoreCase(dbversion)){

    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_23);
    
            }else if ("Access_2007".equalsIgnoreCase(dbversion)){

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_26);
    
            }

    
		}
		
		public String getDirverClassName(INode node){
			return "sun.jdbc.odbc.JdbcOdbcDriver";
		}
		
		public void createConnection(INode node) {
			if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
			} else {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
			}
		}
	}//end class
	
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_47);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
	
    String cid = node.getUniqueName();
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    String dbport = ElementParameterParser.getValue(node, "__PORT__");
    String dbschema = ElementParameterParser.getValue(node, "__DB_SCHEMA__");
    if(dbschema == null||dbschema.trim().length()==0) {
    	 dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
    }
    String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
    String dbuser = ElementParameterParser.getValue(node, "__USER__");
    String dbpass = ElementParameterParser.getValue(node, "__PASS__");
    String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
    
	boolean isUseSharedConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_SHARED_CONNECTION__"));

    
	connUtil.beforeComponentProcess(node);
	
	connUtil.createURL(node);

    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_50);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_51);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_54);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_57);
    } else {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_66);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_67);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_68);
    
		}

    stringBuffer.append(TEXT_69);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_70);
    connUtil.createConnection(node);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
		if(specify_alias){

    stringBuffer.append(TEXT_74);
    
		}
	}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_77);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    return stringBuffer.toString();
  }
}
