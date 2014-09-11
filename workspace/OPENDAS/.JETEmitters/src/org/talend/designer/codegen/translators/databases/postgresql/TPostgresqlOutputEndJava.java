package org.talend.designer.codegen.translators.databases.postgresql;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import java.util.List;

public class TPostgresqlOutputEndJava
{
  protected static String nl;
  public static synchronized TPostgresqlOutputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPostgresqlOutputEndJava result = new TPostgresqlOutputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tjava.sql.Statement stmtCreateGeoColumns_";
  protected final String TEXT_3 = " = conn_";
  protected final String TEXT_4 = ".createStatement();" + NL + "\t\t" + NL + "\t\t// Delete geometry columns entry if already exists. " + NL + "\t\tString deleteGeometryColumns_";
  protected final String TEXT_5 = " = \"DELETE FROM geometry_columns WHERE f_table_name='\" + " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_6 = " + \"' AND f_table_schema='\" + ";
  protected final String TEXT_7 = " +\"'\";" + NL + "\t\tstmtCreateGeoColumns_";
  protected final String TEXT_8 = ".execute(deleteGeometryColumns_";
  protected final String TEXT_9 = ");" + NL + "\t\t\t" + NL + "\t\t// Create new entry in geometry columns table\t" + NL + "        String insertGeometryColumns_";
  protected final String TEXT_10 = " = \"INSERT INTO geometry_columns VALUES ('', '\"+ ";
  protected final String TEXT_11 = " +\"', '\"+ " + NL + "        \t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_12 = " +\"','\"+ geometryColumnName_";
  protected final String TEXT_13 = " +" + NL + "        \t\t\t\t\t\t\t\t\t\t\"', \"+dimension_";
  protected final String TEXT_14 = "+\", \"+ SRID_";
  protected final String TEXT_15 = " +\", 'GEOMETRY')\";" + NL + "        stmtCreateGeoColumns_";
  protected final String TEXT_16 = ".execute(insertGeometryColumns_";
  protected final String TEXT_17 = ");" + NL + "        " + NL + "        stmtCreateGeoColumns_";
  protected final String TEXT_18 = ".close();" + NL + "\t\t";
  protected final String TEXT_19 = NL + "    \tjava.sql.Statement stmtCreateIndex_";
  protected final String TEXT_20 = " = conn_";
  protected final String TEXT_21 = ".createStatement();" + NL + "\t\t// Drop spatial index if exists" + NL + "\t\tString dropIndex_";
  protected final String TEXT_22 = " = \"DROP INDEX IF EXISTS \\\"\"+ tableName_";
  protected final String TEXT_23 = " +\"_geo_index\\\"\";" + NL + "\t\tstmtCreateIndex_";
  protected final String TEXT_24 = ".execute(dropIndex_";
  protected final String TEXT_25 = ");" + NL + "\t\t" + NL + "\t\t// Create spatial index using GIST on geometry columns" + NL + "\t\tString createIndex_";
  protected final String TEXT_26 = " = \"CREATE INDEX \\\"\"+ ";
  protected final String TEXT_27 = " +\"_geo_index\\\" ON \\\"\"+ tableName_";
  protected final String TEXT_28 = " +" + NL + "\t\t\t\t\t\t\t\t \"\\\" USING GIST (\\\"\" + geometryColumnName_";
  protected final String TEXT_29 = " +\"\\\")\";" + NL + "        stmtCreateIndex_";
  protected final String TEXT_30 = ".execute(createIndex_";
  protected final String TEXT_31 = ");" + NL + "       stmtCreateIndex_";
  protected final String TEXT_32 = ".close();" + NL + "\t\t";
  protected final String TEXT_33 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_34 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_35 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_36 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_37 = ".close();" + NL + "            " + NL + "        }" + NL + "        if(pstmt_";
  protected final String TEXT_38 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_39 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_40 = NL + "        if(pstmtUpdate_";
  protected final String TEXT_41 = " != null){" + NL + "" + NL + "            pstmtUpdate_";
  protected final String TEXT_42 = ".close();" + NL + "            " + NL + "        } " + NL + "        if(pstmtInsert_";
  protected final String TEXT_43 = " != null){" + NL + "" + NL + "            pstmtInsert_";
  protected final String TEXT_44 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = "                " + NL + "\t    try {" + NL + "\t\t\t\tpstmt_";
  protected final String TEXT_47 = ".executeBatch();                \t" + NL + "\t\t    \t";
  protected final String TEXT_48 = NL + "\t\t    \t\tinsertedCount_";
  protected final String TEXT_49 = " +=pstmt_";
  protected final String TEXT_50 = ".getUpdateCount(); " + NL + "\t\t    \t";
  protected final String TEXT_51 = NL + "\t\t    \t\tupdatedCount_";
  protected final String TEXT_52 = " += pstmt_";
  protected final String TEXT_53 = ".getUpdateCount();" + NL + "\t\t    \t";
  protected final String TEXT_54 = NL + "\t\t    \t    deletedCount_";
  protected final String TEXT_55 = " += pstmt_";
  protected final String TEXT_56 = ".getUpdateCount();" + NL + "\t\t    \t";
  protected final String TEXT_57 = "            \t    " + NL + "\t    }catch (java.sql.BatchUpdateException e){" + NL + "\t    \t";
  protected final String TEXT_58 = NL + "\t    \t\tthrow(e);" + NL + "\t    \t";
  protected final String TEXT_59 = NL + "\t    \tSystem.out.println(e.getMessage());" + NL + "\t    \t";
  protected final String TEXT_60 = "                \t" + NL + "\t\t}                                  " + NL + "\t    ";
  protected final String TEXT_61 = "   " + NL + "        if(pstmt_";
  protected final String TEXT_62 = " != null) {" + NL + "" + NL + "            pstmt_";
  protected final String TEXT_63 = ".close();" + NL + "            " + NL + "        }        ";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL + "\t\t\tconn_";
  protected final String TEXT_66 = ".commit();";
  protected final String TEXT_67 = "\t" + NL + "    \tconn_";
  protected final String TEXT_68 = " .close();" + NL + "    \t";
  protected final String TEXT_69 = NL + NL + "\tnb_line_deleted_";
  protected final String TEXT_70 = "=nb_line_deleted_";
  protected final String TEXT_71 = "+ deletedCount_";
  protected final String TEXT_72 = ";" + NL + "\tnb_line_update_";
  protected final String TEXT_73 = "=nb_line_update_";
  protected final String TEXT_74 = " + updatedCount_";
  protected final String TEXT_75 = ";" + NL + "\tnb_line_inserted_";
  protected final String TEXT_76 = "=nb_line_inserted_";
  protected final String TEXT_77 = " + insertedCount_";
  protected final String TEXT_78 = ";" + NL + "\tnb_line_rejected_";
  protected final String TEXT_79 = "=nb_line_rejected_";
  protected final String TEXT_80 = " + rejectedCount_";
  protected final String TEXT_81 = ";" + NL + "" + NL + "    globalMap.put(\"";
  protected final String TEXT_82 = "_NB_LINE\",nb_line_";
  protected final String TEXT_83 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_84 = "_NB_LINE_UPDATED\",nb_line_update_";
  protected final String TEXT_85 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_86 = "_NB_LINE_INSERTED\",nb_line_inserted_";
  protected final String TEXT_87 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_88 = "_NB_LINE_DELETED\",nb_line_deleted_";
  protected final String TEXT_89 = ");" + NL + "    globalMap.put(\"";
  protected final String TEXT_90 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	
	String dbschema = ElementParameterParser.getValue(node, "__SCHEMA_DB__");
	
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	boolean useSpatialOptions = ("true").equals(ElementParameterParser.getValue(node,"__USE_SPATIAL_OPTIONS__"));
	
	boolean createSpatialIndex = ("true").equals(ElementParameterParser.getValue(node,"__SPATIAL_INDEX__"));
	
	boolean createGeometryColumns = ("true").equals(ElementParameterParser.getValue(node,"__GEOMETRY_COLUMNS__"));
    
	boolean useBatchSize = ("true").equals(ElementParameterParser.getValue(node,"__USE_BATCH_SIZE__"));
	
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	
	String rejectConnName = null;
    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    if(rejectConns != null && rejectConns.size() > 0) {
        IConnection rejectConn = rejectConns.get(0);
        rejectConnName = rejectConn.getName();
    }
    
    if(createGeometryColumns && useSpatialOptions){
		
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dbschema );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbschema );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
	}
	if(createSpatialIndex && useSpatialOptions){
		
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(tableName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	}
    

	
    if(("INSERT_OR_UPDATE").equals(dataAction)) {
        
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
    } else if(("UPDATE_OR_INSERT").equals(dataAction)) {
        
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
    } else {
        
    stringBuffer.append(TEXT_45);
    if ((rejectConnName==null && useBatchSize) && (("INSERT").equals(dataAction) || ("UPDATE").equals(dataAction) || ("DELETE").equals(dataAction))) {
	    
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    if (("INSERT").equals(dataAction)) {
		    	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    
		    	}else if (("UPDATE").equals(dataAction)) {
		    	
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
		    	}else if (("DELETE").equals(dataAction)) {
		    	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
		    	}
    stringBuffer.append(TEXT_57);
    if(("true").equals(dieOnError)) {
	    	
    stringBuffer.append(TEXT_58);
    
	    	}else {
	    	
    stringBuffer.append(TEXT_59);
    
	    	}
    stringBuffer.append(TEXT_60);
    
	    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    
    }   
    
    stringBuffer.append(TEXT_64);
    
	if(!("true").equals(useExistingConn))
	{
		if(!("").equals(commitEvery) && !("0").equals(commitEvery))
		{
			
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		}
		
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
	}
    
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(TEXT_92);
    return stringBuffer.toString();
  }
}