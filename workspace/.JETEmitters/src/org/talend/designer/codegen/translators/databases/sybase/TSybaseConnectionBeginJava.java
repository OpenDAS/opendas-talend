package org.talend.designer.codegen.translators.databases.sybase;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSybaseConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSybaseConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSybaseConnectionBeginJava result = new TSybaseConnectionBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tjava.lang.Class.forName(\"";
  protected final String TEXT_2 = "\");";
  protected final String TEXT_3 = NL + "\t\t\tString sharedConnectionName_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ";" + NL + "\t\t\tconn_";
  protected final String TEXT_6 = " = SharedDBConnection.getDBConnection(\"";
  protected final String TEXT_7 = "\",url_";
  protected final String TEXT_8 = ",userName_";
  protected final String TEXT_9 = " , password_";
  protected final String TEXT_10 = " , sharedConnectionName_";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\tconn_";
  protected final String TEXT_13 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_14 = ",userName_";
  protected final String TEXT_15 = ",password_";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t\tconn_";
  protected final String TEXT_18 = ".setAutoCommit(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\tString url_";
  protected final String TEXT_21 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_22 = " + \":\" + ";
  protected final String TEXT_23 = " + \"/\" + ";
  protected final String TEXT_24 = "; ";
  protected final String TEXT_25 = NL + "\t\tString url_";
  protected final String TEXT_26 = " = \"jdbc:sybase:Tds:\" + ";
  protected final String TEXT_27 = " + \":\" + ";
  protected final String TEXT_28 = " + \"/\" + ";
  protected final String TEXT_29 = " + \"?\" + ";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + NL + "\t";
  protected final String TEXT_32 = NL + NL + "\tString userName_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "\t";
  protected final String TEXT_36 = NL + "\t\tString password_";
  protected final String TEXT_37 = " = \"null\";" + NL + "\t";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_40 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = "; ";
  protected final String TEXT_45 = NL + "\t\tString password_";
  protected final String TEXT_46 = " = decryptedPassword_";
  protected final String TEXT_47 = ";" + NL + "\t";
  protected final String TEXT_48 = NL + NL + "\tjava.sql.Connection conn_";
  protected final String TEXT_49 = " = null;" + NL;
  protected final String TEXT_50 = NL + "\t";
  protected final String TEXT_51 = NL + NL + "\tif ((null == globalMap.get(KEY_DB_DATASOURCES)) || \"\".equals(";
  protected final String TEXT_52 = ")) {";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_56 = "\", conn_";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t}";
  protected final String TEXT_59 = NL + "\tif (null != conn_";
  protected final String TEXT_60 = ") {" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t}";
  protected final String TEXT_62 = NL + "\t" + NL + "\tglobalMap.put(\"conn_";
  protected final String TEXT_63 = "\", conn_";
  protected final String TEXT_64 = ");" + NL + "\tglobalMap.put(\"host_";
  protected final String TEXT_65 = "\", ";
  protected final String TEXT_66 = ");" + NL + "\tglobalMap.put(\"port_";
  protected final String TEXT_67 = "\", ";
  protected final String TEXT_68 = ");" + NL + "\tglobalMap.put(\"db_";
  protected final String TEXT_69 = "\", ";
  protected final String TEXT_70 = ");" + NL + "\tglobalMap.put(\"user_";
  protected final String TEXT_71 = "\", ";
  protected final String TEXT_72 = ");" + NL + "\tglobalMap.put(\"pass_";
  protected final String TEXT_73 = "\", password_";
  protected final String TEXT_74 = ");" + NL + "\tglobalMap.put(\"dbschema_";
  protected final String TEXT_75 = "\", ";
  protected final String TEXT_76 = ");";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
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

    stringBuffer.append(TEXT_1);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_2);
    
		}
		
		public void useShareConnection(INode node) {
			String sharedConnectionName = ElementParameterParser.getValue(node, "__SHARED_CONNECTION_NAME__");

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sharedConnectionName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(this.getDirverClassName(node));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
		}
		
		public void createConnection(INode node) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
		}
		
		public void setAutoCommit(INode node) {
			boolean setAutoCommit = "true".equals(ElementParameterParser.getValue(node, "__AUTO_COMMIT__"));

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(setAutoCommit);
    stringBuffer.append(TEXT_19);
    
		}
		
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultUtil class
	
	DefaultConnectionUtil connUtil = new DefaultConnectionUtil();

    
	class ConnectionUtil extends DefaultConnectionUtil{
	
		public void createURL(INode node) {
			super.createURL(node);

    
			if(dbproperties == null || ("\"\"").equals(dbproperties) || ("").equals(dbproperties)) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(dbhost );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbport );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(dbname );
    stringBuffer.append(TEXT_24);
    
			} else {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(dbhost );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(dbport );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(dbname );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(dbproperties);
    stringBuffer.append(TEXT_30);
    
			}

    	
		}
	
		public String getDirverClassName(INode node){
			return "com.sybase.jdbc3.jdbc.SybDriver";
		}
		
	}//end class
	connUtil = new ConnectionUtil();

    //----------------------------component codes-----------------------------------------
    stringBuffer.append(TEXT_31);
    
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

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append((dbuser != null && dbuser.trim().length() == 0)? "null":dbuser);
    stringBuffer.append(TEXT_34);
    //the tSQLiteConnection component not contain user and pass return null
    stringBuffer.append(TEXT_35);
    if(dbpass != null && dbpass.trim().length() == 0) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    } else {
		String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_38);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
	if(isUseSharedConnection){

    stringBuffer.append(TEXT_50);
    connUtil.useShareConnection(node);
    
	} else {
		boolean specify_alias = "true".equals(ElementParameterParser.getValue(node, "__SPECIFY_DATASOURCE_ALIAS__"));
		if(specify_alias){
			String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_51);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_52);
    
		}

    stringBuffer.append(TEXT_53);
    connUtil.classForName(node);
    stringBuffer.append(TEXT_54);
    connUtil.createConnection(node);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
		if(specify_alias){

    stringBuffer.append(TEXT_58);
    
		}
	}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    connUtil.setAutoCommit(node);
    stringBuffer.append(TEXT_61);
    
	connUtil.afterComponentProcess(node);

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
