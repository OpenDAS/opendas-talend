package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSalesforceOutputBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBeginJava result = new TSalesforceOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "        int nb_success_";
  protected final String TEXT_3 = " = 0;" + NL + "        int nb_reject_";
  protected final String TEXT_4 = " = 0;" + NL + "" + NL + "        org.talend.salesforce.SforceManagement sforceManagement_";
  protected final String TEXT_5 = " = new org.talend.salesforce.SforceManagementImpl();";
  protected final String TEXT_6 = NL + "        if(globalMap.get(\"stub_";
  protected final String TEXT_7 = "\")==null || globalMap.get(\"sessionHeader_";
  protected final String TEXT_8 = "\")==null){" + NL + "\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_9 = "\");" + NL + "\t\t}" + NL + "\t\tsforceManagement_";
  protected final String TEXT_10 = ".login((com.salesforce.soap.partner.SforceServiceStub)globalMap.get(\"stub_";
  protected final String TEXT_11 = "\"),(com.salesforce.soap.partner.SessionHeader)globalMap.get(\"sessionHeader_";
  protected final String TEXT_12 = "\"), ";
  protected final String TEXT_13 = ", ";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ");\t" + NL + "\t\t";
  protected final String TEXT_16 = NL + "        boolean result_";
  protected final String TEXT_17 = " = sforceManagement_";
  protected final String TEXT_18 = ".login(";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ", ";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");" + NL + "        if(!result_";
  protected final String TEXT_27 = "){" + NL + "\t\t\tthrow new RuntimeException(\"Login failed! Please check the username,password and endpoint\");" + NL + "\t\t}";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");

	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String commitLevel = ElementParameterParser.getValue(node, "__COMMIT_LEVEL__");
	boolean extendedInsert = ("true").equals(ElementParameterParser.getValue(node, "__EXTENDINSERT__"));
	String logFile = ElementParameterParser.getValue(node, "__LOGFILENAME__").trim();
	boolean ceaseForError = ("true").equals(ElementParameterParser.getValue(node, "__CEASE_FOR_ERROR__"));
	boolean needCompression = ("true").equals(ElementParameterParser.getValue(node,"__NEED_COMPRESSION__"));
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
	// if the extended insert is disabled set the commit level to 1
	if (!extendedInsert) commitLevel = "1";

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    if(useExistingConn){
    stringBuffer.append(TEXT_6);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(commitLevel);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ceaseForError );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(logFile );
    stringBuffer.append(TEXT_15);
    }else{
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(endpoint );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(password );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(needCompression);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(commitLevel);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(ceaseForError );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(logFile );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}