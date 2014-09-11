package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSSHBeginJava
{
  protected static String nl;
  public static synchronized TSSHBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHBeginJava result = new TSSHBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tfinal java.util.Vector<String> output_";
  protected final String TEXT_3 = " = new java.util.Vector<String>();";
  protected final String TEXT_4 = NL + "    String hostname_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "    String username_";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "\tglobalMap.remove(\"";
  protected final String TEXT_9 = "_STDOUT\");" + NL + "\tglobalMap.remove(\"";
  protected final String TEXT_10 = "_STDERR\");" + NL + "" + NL + "\t/* Create a connection instance */";
  protected final String TEXT_11 = NL + "\t\t\t  ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_12 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t\t  ch.ethz.ssh2.Connection conn_";
  protected final String TEXT_15 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_16 = ",Integer.parseInt(";
  protected final String TEXT_17 = " + \"\"));";
  protected final String TEXT_18 = NL + "              /* Now connect */";
  protected final String TEXT_19 = NL + "\t\t\t  conn_";
  protected final String TEXT_20 = ".connect(null,0,";
  protected final String TEXT_21 = "*1000);";
  protected final String TEXT_22 = NL + "\t\t\t  conn_";
  protected final String TEXT_23 = ".connect();";
  protected final String TEXT_24 = NL + "        java.io.File keyfile_";
  protected final String TEXT_25 = " = new java.io.File(";
  protected final String TEXT_26 = "); " + NL + "\t\t    boolean isAuthenticated_";
  protected final String TEXT_27 = " = conn_";
  protected final String TEXT_28 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_29 = ", keyfile_";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");" + NL + "\t\t\t  if (isAuthenticated_";
  protected final String TEXT_32 = " == false)" + NL + "\t\t\t\t      throw new RuntimeException(\"Authentication failed.\");";
  protected final String TEXT_33 = NL + "        boolean isAuthenticated_";
  protected final String TEXT_34 = " = conn_";
  protected final String TEXT_35 = ".authenticateWithPassword(username_";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ");" + NL + "\t\tif (isAuthenticated_";
  protected final String TEXT_38 = " == false)" + NL + "\t\t\tthrow new RuntimeException(\"Authentication failed.\");";
  protected final String TEXT_39 = NL + "        boolean isAuthenticated_";
  protected final String TEXT_40 = " = conn_";
  protected final String TEXT_41 = ".authenticateWithKeyboardInteractive(username_";
  protected final String TEXT_42 = ", " + NL + "            new ch.ethz.ssh2.InteractiveCallback() {" + NL + "        " + NL + "        \t\tpublic String[] replyToChallenge(String name," + NL + "        \t\t\t\tString instruction, int numPrompts," + NL + "        \t\t\t\tString[] prompt, boolean[] echo)" + NL + "        \t\t\t\tthrows Exception {" + NL + "        \t\t\t// TODO Auto-generated method stub" + NL + "        \t\t\tString[] reply = new String[numPrompts];" + NL + "        \t\t\tfor (int i = 0; i < reply.length; i++) {" + NL + "        \t\t\t\treply[i] = ";
  protected final String TEXT_43 = ";" + NL + "        \t\t\t}" + NL + "        " + NL + "        \t\t\treturn reply;" + NL + "        \t\t}" + NL + "        \t}\t" + NL + "        );" + NL + "        if (isAuthenticated_";
  protected final String TEXT_44 = " == false)" + NL + "            throw new RuntimeException(\"Authentication failed.\");";
  protected final String TEXT_45 = NL + "        ";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean stats = codeGenArgument.isStatistics();

List<IMetadataTable> metadatas = node.getMetadataList();
String cid = node.getUniqueName();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {

        String host = ElementParameterParser.getValue(
            node,
            "__HOST__"
        );

        String port = ElementParameterParser.getValue(
            node,
            "__PORT__"
        );

        String user = ElementParameterParser.getValue(
            node,
            "__USER__"
        );

        String authMethod = ElementParameterParser.getValue(
            node,
            "__AUTH_METHOD__"
        );

        String privatekey = ElementParameterParser.getValue(
            node,
            "__PRIVATEKEY__"
        );

        String password = ElementParameterParser.getValue(
            node,
            "__PASSWORD__"
        );
        
        String passphrase = ElementParameterParser.getValue(
            node,
            "__PASSPHRASE__"
        );
        
        String useTimeout = ElementParameterParser.getValue(
            node,
            "__USE_TIMEOUT__"
        );

        String timeout = ElementParameterParser.getValue(
            node,
            "__TIMEOUT__"
        );
        
        String standardOutput  = ElementParameterParser.getValue(node, "__STANDARDOUTPUT__");
		String errorOuput  = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
		if (("NORMAL_OUTPUT").equals(standardOutput)||("NORMAL_OUTPUT").equals(errorOuput)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
		}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
        if(("").equals(port)){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        } else {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_17);
    
        }

    stringBuffer.append(TEXT_18);
    
        if(("true").equals(useTimeout)){

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_21);
    
        } else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
        }
        
        if (("PUBLICKEY").equals(authMethod)) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(passphrase);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
        }
        if (("PASSWORD").equals(authMethod)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
        }
        
        if (("KEYBOARDINTERACTIVE").equals(authMethod)) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
        }

    stringBuffer.append(TEXT_45);
    
    }
}

    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}