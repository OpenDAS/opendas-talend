package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;

public class TFileInputJSONBeginJava
{
  protected static String nl;
  public static synchronized TFileInputJSONBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputJSONBeginJava result = new TFileInputJSONBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  class JSONUtil_";
  protected final String TEXT_2 = "{" + NL + "      public int getData(String query,javax.script.Invocable invocableEngine,java.util.List<org.json.simple.JSONArray> jsonResultList,int recordMaxSize){" + NL + "          try{" + NL + "              //only 2 types: String/Boolean" + NL + "              String resultObj = invocableEngine.invokeFunction(\"jsonPath\",query).toString();" + NL + "              if(!\"false\".equals(resultObj)){" + NL + "\t              org.json.simple.JSONArray resultArray= (org.json.simple.JSONArray)org.json.simple.JSONValue.parse(resultObj);" + NL + "\t              jsonResultList.add(resultArray);" + NL + "\t              if(recordMaxSize != -1 && recordMaxSize != resultArray.size()){" + NL + "\t\t             //just give an error, don't stop" + NL + "\t\t              System.err.println(\"The Json resource datas maybe have some problems, please make sure the data structure with the same fields.\");" + NL + "\t               }" + NL + "\t               recordMaxSize = Math.max(recordMaxSize, resultArray.size());" + NL + "               }else{" + NL + "\t               System.err.println(\"Can't find any data with JSONPath \" + query);" + NL + "\t               //add null to take a place in List(buffer)" + NL + "\t               jsonResultList.add(null); " + NL + "               }" + NL + "          }catch(java.lang.Exception e){" + NL + "              e.printStackTrace();" + NL + "          }" + NL + "          return recordMaxSize;" + NL + "      }" + NL;
  protected final String TEXT_3 = NL + "\t                   void setRowValue_";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = "Struct ";
  protected final String TEXT_6 = ", java.util.List<org.json.simple.JSONArray> JSONResultList_";
  protected final String TEXT_7 = ", int nbResultArray_";
  protected final String TEXT_8 = ") throws java.io.UnsupportedEncodingException{";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t\t        if(JSONResultList_";
  protected final String TEXT_10 = ".get(";
  protected final String TEXT_11 = ") != null && nbResultArray_";
  protected final String TEXT_12 = "<JSONResultList_";
  protected final String TEXT_13 = ".get(";
  protected final String TEXT_14 = ").size() && JSONResultList_";
  protected final String TEXT_15 = ".get(";
  protected final String TEXT_16 = ").get(nbResultArray_";
  protected final String TEXT_17 = ")!=null){";
  protected final String TEXT_18 = "\t\t" + NL + "\t\t\t                                ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = " = JSONResultList_";
  protected final String TEXT_21 = ".get(";
  protected final String TEXT_22 = ").get(nbResultArray_";
  protected final String TEXT_23 = ").toString();";
  protected final String TEXT_24 = "\t\t\t\t\t" + NL + "\t\t\t                                ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = " = ParserUtils.parseTo_Date(JSONResultList_";
  protected final String TEXT_27 = ".get(";
  protected final String TEXT_28 = ").get(nbResultArray_";
  protected final String TEXT_29 = ").toString(), ";
  protected final String TEXT_30 = ");\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t                                ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = " = ParserUtils.parseTo_";
  protected final String TEXT_34 = "(ParserUtils.parseTo_Number(JSONResultList_";
  protected final String TEXT_35 = ".get(";
  protected final String TEXT_36 = ").get(nbResultArray_";
  protected final String TEXT_37 = ").toString(), ";
  protected final String TEXT_38 = ", ";
  protected final String TEXT_39 = "));";
  protected final String TEXT_40 = "\t\t\t\t\t\t\t" + NL + "\t\t\t                                ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = " = JSONResultList_";
  protected final String TEXT_43 = ".get(";
  protected final String TEXT_44 = ").get(nbResultArray_";
  protected final String TEXT_45 = ").toString().getBytes(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t\t                                ";
  protected final String TEXT_48 = ".";
  protected final String TEXT_49 = " = ParserUtils.parseTo_";
  protected final String TEXT_50 = "(JSONResultList_";
  protected final String TEXT_51 = ".get(";
  protected final String TEXT_52 = ").get(nbResultArray_";
  protected final String TEXT_53 = ").toString());";
  protected final String TEXT_54 = NL + "\t\t\t\t\t\t\t        }else{" + NL;
  protected final String TEXT_55 = NL + "\t\t\t                                throw new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_56 = "' in '";
  protected final String TEXT_57 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_58 = NL + "\t\t                                    ";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ";" + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t                             }";
  protected final String TEXT_63 = NL + "\t\t\t             }";
  protected final String TEXT_64 = NL + "                    }";
  protected final String TEXT_65 = NL + "  }" + NL + "int nb_line_";
  protected final String TEXT_66 = " = 0;" + NL + "java.lang.Object jsonText_";
  protected final String TEXT_67 = " = null;" + NL + "JSONUtil_";
  protected final String TEXT_68 = " jsonUtil_";
  protected final String TEXT_69 = "=new JSONUtil_";
  protected final String TEXT_70 = "();" + NL + "java.util.List<org.json.simple.JSONArray> JSONResultList_";
  protected final String TEXT_71 = " = new java.util.ArrayList<org.json.simple.JSONArray>();" + NL + "int recordMaxSize_";
  protected final String TEXT_72 = " = -1;" + NL + "" + NL + "//init js json engine" + NL + "javax.script.ScriptEngineManager scriptEngineMgr_";
  protected final String TEXT_73 = " = new javax.script.ScriptEngineManager();" + NL + "javax.script.ScriptEngine jsEngine_";
  protected final String TEXT_74 = " = scriptEngineMgr_";
  protected final String TEXT_75 = ".getEngineByName(\"JavaScript\");" + NL + "if (jsEngine_";
  protected final String TEXT_76 = " == null) {" + NL + "    System.err.println(\"No script engine found for JavaScript\");" + NL + "} else {" + NL + "    java.net.URL jsonjsUrl_";
  protected final String TEXT_77 = " = com.jsonpath.test.ReadJar.class.getResource(\"json.js\");" + NL + "    if(jsonjsUrl_";
  protected final String TEXT_78 = "!=null) {" + NL + "    \tjsEngine_";
  protected final String TEXT_79 = ".eval(new java.io.BufferedReader(new java.io.InputStreamReader(jsonjsUrl_";
  protected final String TEXT_80 = ".openStream())));" + NL + "    }" + NL + "    " + NL + "    java.net.URL jsonpathjsUrl_";
  protected final String TEXT_81 = " = com.jsonpath.test.ReadJar.class.getResource(\"jsonpath.js\");" + NL + "    if(jsonpathjsUrl_";
  protected final String TEXT_82 = "!=null) {" + NL + "\t\tjsEngine_";
  protected final String TEXT_83 = ".eval(new java.io.BufferedReader(new java.io.InputStreamReader(jsonpathjsUrl_";
  protected final String TEXT_84 = ".openStream())));" + NL + "\t}" + NL;
  protected final String TEXT_85 = NL + "\tjava.io.BufferedReader fr_";
  protected final String TEXT_86 = " = null;";
  protected final String TEXT_87 = NL + "\tjava.io.InputStreamReader fr_";
  protected final String TEXT_88 = " = null;";
  protected final String TEXT_89 = NL + "\ttry{" + NL + "\t";
  protected final String TEXT_90 = NL + "\t\tfr_";
  protected final String TEXT_91 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(";
  protected final String TEXT_92 = "),";
  protected final String TEXT_93 = "));" + NL + "\t";
  protected final String TEXT_94 = NL + "\t\tjava.net.URL url_";
  protected final String TEXT_95 = " = new java.net.URL(";
  protected final String TEXT_96 = ");" + NL + "\t\tjava.net.URLConnection urlConn_";
  protected final String TEXT_97 = " = url_";
  protected final String TEXT_98 = ".openConnection();" + NL + "\t\tfr_";
  protected final String TEXT_99 = " = new java.io.InputStreamReader(urlConn_";
  protected final String TEXT_100 = ".getInputStream(),";
  protected final String TEXT_101 = ");" + NL + "\t";
  protected final String TEXT_102 = NL + "\t\tjsonText_";
  protected final String TEXT_103 = " = org.json.simple.JSONValue.parse(fr_";
  protected final String TEXT_104 = ");" + NL + "\t\tif(jsonText_";
  protected final String TEXT_105 = " == null) {" + NL + "\t\t\tthrow new RuntimeException(\"fail to parse the json file : \" + ";
  protected final String TEXT_106 = " ";
  protected final String TEXT_107 = " ";
  protected final String TEXT_108 = " ";
  protected final String TEXT_109 = " ";
  protected final String TEXT_110 = ");" + NL + "\t\t}" + NL + "\t} catch(java.lang.Exception e_";
  protected final String TEXT_111 = ") {" + NL + "\t";
  protected final String TEXT_112 = NL + "\t\tthrow e_";
  protected final String TEXT_113 = ";" + NL + "\t";
  protected final String TEXT_114 = NL + " \t\tSystem.err.println(e_";
  protected final String TEXT_115 = ".getMessage());" + NL + "\t";
  protected final String TEXT_116 = NL + "\t} finally {" + NL + "\t\tif(fr_";
  protected final String TEXT_117 = " != null ) {" + NL + "\t\t\tfr_";
  protected final String TEXT_118 = ".close();" + NL + "\t\t}" + NL + "    }" + NL + "" + NL + "\tif(jsonText_";
  protected final String TEXT_119 = "!=null) {" + NL + "\t\tjsEngine_";
  protected final String TEXT_120 = ".eval(\"var obj=\"+jsonText_";
  protected final String TEXT_121 = ".toString());" + NL + "" + NL + "\t\tjavax.script.Invocable invocableEngine_";
  protected final String TEXT_122 = " = (javax.script.Invocable)jsEngine_";
  protected final String TEXT_123 = ";" + NL;
  protected final String TEXT_124 = NL + NL + "\t\trecordMaxSize_";
  protected final String TEXT_125 = "=jsonUtil_";
  protected final String TEXT_126 = ".getData(";
  protected final String TEXT_127 = ",invocableEngine_";
  protected final String TEXT_128 = ",JSONResultList_";
  protected final String TEXT_129 = ",recordMaxSize_";
  protected final String TEXT_130 = ");" + NL;
  protected final String TEXT_131 = NL + "\t}" + NL + "}" + NL + "" + NL + "\tfor(int nbResultArray_";
  protected final String TEXT_132 = " = 0; nbResultArray_";
  protected final String TEXT_133 = " < recordMaxSize_";
  protected final String TEXT_134 = "; nbResultArray_";
  protected final String TEXT_135 = "++){" + NL + "\t" + NL + "\t\tnb_line_";
  protected final String TEXT_136 = "++;";
  protected final String TEXT_137 = NL + "\t\t\t\t\t";
  protected final String TEXT_138 = " = null;\t\t\t";
  protected final String TEXT_139 = NL + "                \tboolean whetherReject_";
  protected final String TEXT_140 = " = false;" + NL + "                \t";
  protected final String TEXT_141 = " = new ";
  protected final String TEXT_142 = "Struct();" + NL + "                \ttry{";
  protected final String TEXT_143 = NL + "                            jsonUtil_";
  protected final String TEXT_144 = ".setRowValue_";
  protected final String TEXT_145 = "(";
  protected final String TEXT_146 = ",JSONResultList_";
  protected final String TEXT_147 = ",nbResultArray_";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = " ";
  protected final String TEXT_150 = NL + "                            ";
  protected final String TEXT_151 = " = null; ";
  protected final String TEXT_152 = NL + "                    } catch (java.lang.Exception e) {" + NL + "                        whetherReject_";
  protected final String TEXT_153 = " = true;";
  protected final String TEXT_154 = NL + "                            throw(e);";
  protected final String TEXT_155 = NL + "                                ";
  protected final String TEXT_156 = " = new ";
  protected final String TEXT_157 = "Struct();";
  protected final String TEXT_158 = NL + "                                    ";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = " = ";
  protected final String TEXT_161 = ".";
  protected final String TEXT_162 = ";";
  protected final String TEXT_163 = NL + "                                ";
  protected final String TEXT_164 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_165 = ";";
  protected final String TEXT_166 = NL + "                                ";
  protected final String TEXT_167 = " = null;";
  protected final String TEXT_168 = NL + "                                System.err.println(e.getMessage());";
  protected final String TEXT_169 = NL + "                                ";
  protected final String TEXT_170 = " = null;";
  protected final String TEXT_171 = NL + "\t\t\t\t                ";
  protected final String TEXT_172 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_173 = ";";
  protected final String TEXT_174 = NL + "                    }";
  protected final String TEXT_175 = NL + NL + "    int nb_line_";
  protected final String TEXT_176 = " = 0;" + NL + "" + NL + "    class XML_API_";
  protected final String TEXT_177 = "{" + NL + "        public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "            if (node != null && node instanceof org.dom4j.Element) {" + NL + "                org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute(\"nil\");" + NL + "                if(attri != null && (\"true\").equals(attri.getText())){" + NL + "                    return true;" + NL + "                }" + NL + "            }" + NL + "            return false;" + NL + "        }" + NL + "    " + NL + "        public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "            return node == null ? true : false;" + NL + "        }" + NL + "    " + NL + "        public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {" + NL + "            if (node != null) {" + NL + "                return node.getText().length() == 0;" + NL + "            }" + NL + "            return false;" + NL + "        }" + NL + "    }" + NL + "" + NL + "    class ConvertJSONString_";
  protected final String TEXT_178 = "{" + NL + "        final static int Brace = 0 ; // {" + NL + "        final static int Bracket = 1; // [" + NL + "        private int barceType = -1 ;" + NL + "        private String originalJsonString = \"\" ;" + NL + "        private String originalLoopString = \"\" ;" + NL + "        private String jsonString4XML = null;" + NL + "        private String loopString4XML = null;" + NL + "        private String additionRoot = null;" + NL + "        " + NL + "        public void barceType(){" + NL + "" + NL + "            for (int c = 0; c < originalJsonString.length(); ++c) {" + NL + "                if (originalJsonString.charAt(c) == '{') {" + NL + "                    barceType = Brace;" + NL + "                    break;" + NL + "                } else if (originalJsonString.charAt(c) == '[') {" + NL + "                    barceType = Bracket;" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public void setJsonString (String originalJsonString) {" + NL + "            this.originalJsonString = originalJsonString;" + NL + "        }" + NL + "        " + NL + "        public void setLoopString (String originalLoopString) {" + NL + "            this.originalLoopString = originalLoopString;" + NL + "        }" + NL + "        " + NL + "        public String getJsonString4XML(){" + NL + "            return jsonString4XML;" + NL + "        }" + NL + "        " + NL + "        public String getLoopString4XML(){" + NL + "            if(loopString4XML.length()>1 && loopString4XML.endsWith(\"/\")){" + NL + "                loopString4XML = loopString4XML.substring(0, loopString4XML.length()-1);" + NL + "            }" + NL + "            return loopString4XML;" + NL + "        }" + NL + "    " + NL + "        public void setAdditionRoot (String additionRoot) {" + NL + "            this.additionRoot = additionRoot;" + NL + "        }" + NL + "                    " + NL + "        public String getAdditionRoot (){" + NL + "            return additionRoot;" + NL + "        }" + NL + "                    " + NL + "        " + NL + "        public void generate() {" + NL + "            barceType();" + NL + "            jsonString4XML = originalJsonString;" + NL + "            loopString4XML = originalLoopString;" + NL + "            if (Brace == barceType) {" + NL + "                if (isNeedAddRoot(originalJsonString)) {" + NL + "                    jsonString4XML = \"{ \\\"root\\\": \" + originalJsonString + \" }\";" + NL + "                    loopString4XML = \"root\" + originalLoopString;" + NL + "                    setAdditionRoot(\"root\");" + NL + "                }" + NL + "            } else if (Bracket == barceType) {" + NL + "                jsonString4XML = \"{ \\\"root\\\" : { \\\"object\\\": \"" + NL + "                        + originalJsonString + \" } }\";" + NL + "                loopString4XML = \"root/object\" + originalLoopString;" + NL + "                setAdditionRoot(\"object\");" + NL + "            }" + NL + "        }" + NL + "" + NL + "        public boolean isNeedAddRoot(String originalJsonString) {" + NL + "            boolean isNeedAddRoot = false;" + NL + "            net.sf.json.JSONObject jso = net.sf.json.JSONObject" + NL + "                    .fromObject(originalJsonString);" + NL + "            String jsonKey = \"\";" + NL + "            Object firstObject = null;" + NL + "            if (jso.names().size() == 1) {" + NL + "                jsonKey = jso.names().get(0).toString();" + NL + "                firstObject = jso.get(jsonKey);" + NL + "            }" + NL + "            if (jso.size() > 1" + NL + "                    || (firstObject != null" + NL + "                            && firstObject instanceof net.sf.json.JSONArray && ((net.sf.json.JSONArray) firstObject)" + NL + "                            .size() > 1)) {" + NL + "                isNeedAddRoot = true;" + NL + "            }" + NL + "            return isNeedAddRoot;" + NL + "        }" + NL + "                " + NL + "    }" + NL + "" + NL + "        ConvertJSONString_";
  protected final String TEXT_179 = " cjs_";
  protected final String TEXT_180 = " = new ConvertJSONString_";
  protected final String TEXT_181 = "();" + NL + "        " + NL + "        de.odysseus.staxon.json.JsonXMLConfig config_";
  protected final String TEXT_182 = " = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).build();" + NL + "        de.odysseus.staxon.json.JsonXMLInputFactory jsonXMLInputFactory_";
  protected final String TEXT_183 = " = new de.odysseus.staxon.json.JsonXMLInputFactory(config_";
  protected final String TEXT_184 = ");" + NL + "        javax.xml.stream.XMLOutputFactory xmlOutputFactory_";
  protected final String TEXT_185 = " = javax.xml.stream.XMLOutputFactory.newInstance();" + NL + "        boolean isGetWholeJson_";
  protected final String TEXT_186 = " = false;" + NL;
  protected final String TEXT_187 = NL + "            class OriginalJSONString_";
  protected final String TEXT_188 = " {" + NL + "" + NL + "                String originalJSONString = null;" + NL + "                java.io.ByteArrayInputStream bais = null;" + NL + "                java.io.ByteArrayOutputStream baos = null;" + NL + "                de.odysseus.staxon.json.JsonXMLConfig config = null;" + NL + "                de.odysseus.staxon.json.JsonXMLOutputFactory jxof = null;" + NL + "                " + NL + "                public String getOriginalJSONString(String xmlString,String additionRoot,String encoding,boolean isGetWholeJson) throws Exception {" + NL + "" + NL + "                    try {" + NL + "                        bais = new ByteArrayInputStream(xmlString.getBytes(encoding));" + NL + "                        baos = new java.io.ByteArrayOutputStream();" + NL + "                        config = new de.odysseus.staxon.json.JsonXMLConfigBuilder().multiplePI(false).autoArray(true).build();" + NL + "                        jxof = new de.odysseus.staxon.json.JsonXMLOutputFactory(config);" + NL + "                        javax.xml.stream.XMLEventReader xmlEventReader = javax.xml.stream.XMLInputFactory.newInstance().createXMLEventReader(bais);" + NL + "                        javax.xml.stream.XMLEventWriter xmLEventWriter = jxof.createXMLEventWriter(baos,encoding);" + NL + "                        xmLEventWriter.add(xmlEventReader);" + NL + "                        xmlEventReader.close();" + NL + "                        xmLEventWriter.close();" + NL + "                        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(baos.toString());" + NL + "                        net.sf.json.JSONObject originalJsonObject = null;" + NL + "                        if (!json.isNullObject()) {" + NL + "                            if (additionRoot == null) {" + NL + "                                originalJSONString = json.toString();" + NL + "                            } else {" + NL + "                                if (isGetWholeJson) {" + NL + "                                    originalJsonObject = json.getJSONObject(additionRoot);" + NL + "                                    if (!originalJsonObject.isNullObject()) {" + NL + "                                        originalJSONString = originalJsonObject.toString();" + NL + "                                    } " + NL + "                                }else {" + NL + "                                        originalJSONString = json.toString();" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                    } finally {" + NL + "                        baos.close();" + NL + "                        if(bais!=null){" + NL + "                            bais.close();" + NL + "                        }" + NL + "                    }" + NL + "                    " + NL + "                    return originalJSONString;" + NL + "                }" + NL + "            }" + NL + "            " + NL + "            OriginalJSONString_";
  protected final String TEXT_189 = " originalJSONString_";
  protected final String TEXT_190 = " = new OriginalJSONString_";
  protected final String TEXT_191 = "();";
  protected final String TEXT_192 = "        " + NL + "        " + NL + "        org.dom4j.io.SAXReader reader_";
  protected final String TEXT_193 = " = new org.dom4j.io.SAXReader();" + NL + "        Object filename_";
  protected final String TEXT_194 = " = null;" + NL + "        try {" + NL + "            filename_";
  protected final String TEXT_195 = " = ";
  protected final String TEXT_196 = ";" + NL + "        } catch(java.lang.Exception e_";
  protected final String TEXT_197 = ") {";
  protected final String TEXT_198 = NL + "            \tthrow(e_";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\t            System.err.println(e_";
  protected final String TEXT_201 = ".getMessage());";
  protected final String TEXT_202 = NL + "        }" + NL + "                " + NL + "        boolean isValidFile_";
  protected final String TEXT_203 = " = true;" + NL + "        org.dom4j.Document doc_";
  protected final String TEXT_204 = " = null;" + NL + "        java.io.BufferedReader br_";
  protected final String TEXT_205 = " = null;" + NL + "        java.lang.StringBuilder jsonBuffer_";
  protected final String TEXT_206 = " =  new java.lang.StringBuilder(\"\");" + NL + "        String jsonStr_";
  protected final String TEXT_207 = " = null;" + NL + "        String xmlStr_";
  protected final String TEXT_208 = " = \"\";" + NL + "        String line_";
  protected final String TEXT_209 = " = null;" + NL + "        " + NL + "        String loopQuery_";
  protected final String TEXT_210 = " =  ";
  protected final String TEXT_211 = " ;" + NL + "        java.io.ByteArrayInputStream bais_";
  protected final String TEXT_212 = " = null;" + NL + "        java.io.ByteArrayOutputStream  baos_";
  protected final String TEXT_213 = " = new java.io.ByteArrayOutputStream();" + NL + "            " + NL + "        try{" + NL + "            if(filename_";
  protected final String TEXT_214 = " instanceof java.io.InputStream){" + NL + "                br_";
  protected final String TEXT_215 = " = new java.io.BufferedReader(new java.io.InputStreamReader((java.io.InputStream)filename_";
  protected final String TEXT_216 = ",";
  protected final String TEXT_217 = "));" + NL + "            }else{";
  protected final String TEXT_218 = NL + "            \t    br_";
  protected final String TEXT_219 = " = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_220 = ")), ";
  protected final String TEXT_221 = "));";
  protected final String TEXT_222 = NL + "\t\t\t\t\tjava.net.URL url_";
  protected final String TEXT_223 = " = new java.net.URL(";
  protected final String TEXT_224 = ");" + NL + "\t\t\t\t\tjava.net.URLConnection urlConn_";
  protected final String TEXT_225 = " = url_";
  protected final String TEXT_226 = ".openConnection();" + NL + "\t\t\t\t\tbr_";
  protected final String TEXT_227 = " = new java.io.BufferedReader( new java.io.InputStreamReader(urlConn_";
  protected final String TEXT_228 = ".getInputStream(),";
  protected final String TEXT_229 = "));";
  protected final String TEXT_230 = NL + "            }" + NL + "            while ((line_";
  protected final String TEXT_231 = " = br_";
  protected final String TEXT_232 = ".readLine()) != null){" + NL + "                jsonBuffer_";
  protected final String TEXT_233 = ".append(line_";
  protected final String TEXT_234 = ");" + NL + "            }" + NL + "            jsonStr_";
  protected final String TEXT_235 = " = jsonBuffer_";
  protected final String TEXT_236 = ".toString();" + NL + "            cjs_";
  protected final String TEXT_237 = ".setJsonString(jsonStr_";
  protected final String TEXT_238 = ");" + NL + "            cjs_";
  protected final String TEXT_239 = ".setLoopString(loopQuery_";
  protected final String TEXT_240 = ");" + NL + "            cjs_";
  protected final String TEXT_241 = ".generate();" + NL + "            jsonStr_";
  protected final String TEXT_242 = " = cjs_";
  protected final String TEXT_243 = ".getJsonString4XML();" + NL + "            loopQuery_";
  protected final String TEXT_244 = " = cjs_";
  protected final String TEXT_245 = ".getLoopString4XML();" + NL + "            bais_";
  protected final String TEXT_246 = " = new ByteArrayInputStream(jsonStr_";
  protected final String TEXT_247 = ".getBytes(";
  protected final String TEXT_248 = "));" + NL + "            javax.xml.stream.XMLEventReader xmlEventReader_";
  protected final String TEXT_249 = " = jsonXMLInputFactory_";
  protected final String TEXT_250 = ".createXMLEventReader(bais_";
  protected final String TEXT_251 = ");" + NL + "            javax.xml.stream.XMLEventWriter xmLEventWriter_";
  protected final String TEXT_252 = " = xmlOutputFactory_";
  protected final String TEXT_253 = ".createXMLEventWriter(baos_";
  protected final String TEXT_254 = ",";
  protected final String TEXT_255 = ");" + NL + "            xmLEventWriter_";
  protected final String TEXT_256 = ".add(xmlEventReader_";
  protected final String TEXT_257 = ");" + NL + "            //convert json string to xml" + NL + "            xmlStr_";
  protected final String TEXT_258 = " = baos_";
  protected final String TEXT_259 = ".toString();  " + NL + "            xmLEventWriter_";
  protected final String TEXT_260 = ".close();" + NL + "            xmlEventReader_";
  protected final String TEXT_261 = ".close();" + NL + "            doc_";
  protected final String TEXT_262 = "= reader_";
  protected final String TEXT_263 = ".read(new java.io.StringReader(xmlStr_";
  protected final String TEXT_264 = "));" + NL + "        }catch(java.lang.Exception e_";
  protected final String TEXT_265 = "){";
  protected final String TEXT_266 = NL + "                throw(e_";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "                    System.err.println( e_";
  protected final String TEXT_269 = ".getMessage());" + NL + "                    isValidFile_";
  protected final String TEXT_270 = " = false;";
  protected final String TEXT_271 = NL + "        } finally {" + NL + "            if(br_";
  protected final String TEXT_272 = "!=null) {" + NL + "                br_";
  protected final String TEXT_273 = ".close();" + NL + "            }" + NL + "            baos_";
  protected final String TEXT_274 = ".close();" + NL + "            if(bais_";
  protected final String TEXT_275 = "!=null){" + NL + "                bais_";
  protected final String TEXT_276 = ".close();" + NL + "            }" + NL + "        }" + NL + "        if(isValidFile_";
  protected final String TEXT_277 = "){" + NL + "    " + NL + "            org.dom4j.XPath x_";
  protected final String TEXT_278 = " = doc_";
  protected final String TEXT_279 = ".createXPath(loopQuery_";
  protected final String TEXT_280 = "); " + NL + "            java.util.HashMap<String,String> xmlNameSpaceMap_";
  protected final String TEXT_281 = " = new java.util.HashMap<String, String>();" + NL + "            x_";
  protected final String TEXT_282 = " = doc_";
  protected final String TEXT_283 = ".createXPath(loopQuery_";
  protected final String TEXT_284 = "); " + NL + "            x_";
  protected final String TEXT_285 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_286 = "); " + NL + "            java.util.List<org.dom4j.tree.AbstractNode> nodeList_";
  protected final String TEXT_287 = " = (java.util.List<org.dom4j.tree.AbstractNode>)x_";
  protected final String TEXT_288 = ".selectNodes(doc_";
  protected final String TEXT_289 = ");  " + NL + "            XML_API_";
  protected final String TEXT_290 = " xml_api_";
  protected final String TEXT_291 = " = new XML_API_";
  protected final String TEXT_292 = "();" + NL + "            String str_";
  protected final String TEXT_293 = " = \"\";" + NL + "            org.dom4j.Node node_";
  protected final String TEXT_294 = " = null;" + NL + "    " + NL + "            //init all mapping xpaths";
  protected final String TEXT_295 = NL + "                org.dom4j.XPath xTmp";
  protected final String TEXT_296 = "_";
  protected final String TEXT_297 = " = org.dom4j.DocumentHelper.createXPath(";
  protected final String TEXT_298 = ");" + NL + "                xTmp";
  protected final String TEXT_299 = "_";
  protected final String TEXT_300 = ".setNamespaceURIs(xmlNameSpaceMap_";
  protected final String TEXT_301 = ");";
  protected final String TEXT_302 = NL + NL + "            for (org.dom4j.tree.AbstractNode temp_";
  protected final String TEXT_303 = ": nodeList_";
  protected final String TEXT_304 = ") {" + NL + "                nb_line_";
  protected final String TEXT_305 = "++;";
  protected final String TEXT_306 = NL + "    ";
  protected final String TEXT_307 = " = null;            ";
  protected final String TEXT_308 = NL + "                    boolean whetherReject_";
  protected final String TEXT_309 = " = false;";
  protected final String TEXT_310 = NL + "                    ";
  protected final String TEXT_311 = " = new ";
  protected final String TEXT_312 = "Struct();" + NL + "                    try{";
  protected final String TEXT_313 = NL + "                                isGetWholeJson_";
  protected final String TEXT_314 = "  = true;";
  protected final String TEXT_315 = NL + "                        Object obj";
  protected final String TEXT_316 = "_";
  protected final String TEXT_317 = " = xTmp";
  protected final String TEXT_318 = "_";
  protected final String TEXT_319 = ".evaluate(temp_";
  protected final String TEXT_320 = ");" + NL + "                        if(obj";
  protected final String TEXT_321 = "_";
  protected final String TEXT_322 = " == null) {" + NL + "                            node_";
  protected final String TEXT_323 = " = null;";
  protected final String TEXT_324 = NL + "                               str_";
  protected final String TEXT_325 = " = null;";
  protected final String TEXT_326 = NL + "                               str_";
  protected final String TEXT_327 = " = \"\";";
  protected final String TEXT_328 = NL + "                        } else if(obj";
  protected final String TEXT_329 = "_";
  protected final String TEXT_330 = " instanceof org.dom4j.Node) {" + NL + "                            node_";
  protected final String TEXT_331 = " = (org.dom4j.Node)obj";
  protected final String TEXT_332 = "_";
  protected final String TEXT_333 = ";";
  protected final String TEXT_334 = NL + "                                str_";
  protected final String TEXT_335 = " = originalJSONString_";
  protected final String TEXT_336 = ".getOriginalJSONString(node_";
  protected final String TEXT_337 = ".asXML(),cjs_";
  protected final String TEXT_338 = ".getAdditionRoot(),";
  protected final String TEXT_339 = ",isGetWholeJson_";
  protected final String TEXT_340 = ");" + NL + "                                isGetWholeJson_";
  protected final String TEXT_341 = " = false;";
  protected final String TEXT_342 = NL + "                                str_";
  protected final String TEXT_343 = " = org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_344 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_345 = NL + "                        } else if(obj";
  protected final String TEXT_346 = "_";
  protected final String TEXT_347 = " instanceof String || obj";
  protected final String TEXT_348 = "_";
  protected final String TEXT_349 = " instanceof Number){" + NL + "                            node_";
  protected final String TEXT_350 = " = temp_";
  protected final String TEXT_351 = ";" + NL + "                            str_";
  protected final String TEXT_352 = " = String.valueOf(obj";
  protected final String TEXT_353 = "_";
  protected final String TEXT_354 = ");" + NL + "                        } else if(obj";
  protected final String TEXT_355 = "_";
  protected final String TEXT_356 = " instanceof java.util.List){" + NL + "                            java.util.List<org.dom4j.Node> nodes_";
  protected final String TEXT_357 = " = (java.util.List<org.dom4j.Node>)obj";
  protected final String TEXT_358 = "_";
  protected final String TEXT_359 = ";" + NL + "                            node_";
  protected final String TEXT_360 = " = nodes_";
  protected final String TEXT_361 = ".size()>0 ? nodes_";
  protected final String TEXT_362 = ".get(0) : null;";
  protected final String TEXT_363 = NL + "                                if(node_";
  protected final String TEXT_364 = "==null){" + NL + "                                    str_";
  protected final String TEXT_365 = " = null;" + NL + "                                }else{" + NL + "                                    str_";
  protected final String TEXT_366 = " = originalJSONString_";
  protected final String TEXT_367 = ".getOriginalJSONString(node_";
  protected final String TEXT_368 = ".asXML(),cjs_";
  protected final String TEXT_369 = ".getAdditionRoot(),";
  protected final String TEXT_370 = ",isGetWholeJson_";
  protected final String TEXT_371 = ");" + NL + "                                }" + NL + "                                isGetWholeJson_";
  protected final String TEXT_372 = " = false;";
  protected final String TEXT_373 = NL + "                                str_";
  protected final String TEXT_374 = " = node_";
  protected final String TEXT_375 = "==null?\"\":org.jaxen.function.StringFunction.evaluate(node_";
  protected final String TEXT_376 = ",org.jaxen.dom4j.DocumentNavigator.getInstance());";
  protected final String TEXT_377 = NL + "                        }";
  protected final String TEXT_378 = NL + "                                        ";
  protected final String TEXT_379 = ".";
  protected final String TEXT_380 = " = str_";
  protected final String TEXT_381 = ";";
  protected final String TEXT_382 = NL + "                                            if(xml_api_";
  protected final String TEXT_383 = ".isDefNull(node_";
  protected final String TEXT_384 = ")){";
  protected final String TEXT_385 = NL + "                                                    ";
  protected final String TEXT_386 = ".";
  protected final String TEXT_387 = " =null;" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_388 = ".isEmpty(node_";
  protected final String TEXT_389 = ")){";
  protected final String TEXT_390 = NL + "                                                ";
  protected final String TEXT_391 = ".";
  protected final String TEXT_392 = " =\"\";" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_393 = ".isMissing(node_";
  protected final String TEXT_394 = " )){ ";
  protected final String TEXT_395 = NL + "                                                ";
  protected final String TEXT_396 = ".";
  protected final String TEXT_397 = " =";
  protected final String TEXT_398 = ";" + NL + "                                            }else{";
  protected final String TEXT_399 = NL + "                                            if(xml_api_";
  protected final String TEXT_400 = ".isEmpty(node_";
  protected final String TEXT_401 = ")){";
  protected final String TEXT_402 = NL + "                                                ";
  protected final String TEXT_403 = ".";
  protected final String TEXT_404 = " =\"\";" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_405 = ".isMissing(node_";
  protected final String TEXT_406 = " )){ ";
  protected final String TEXT_407 = NL + "                                                ";
  protected final String TEXT_408 = ".";
  protected final String TEXT_409 = " =";
  protected final String TEXT_410 = ";" + NL + "                                            }else{";
  protected final String TEXT_411 = "  " + NL + "                                            if(xml_api_";
  protected final String TEXT_412 = ".isDefNull(node_";
  protected final String TEXT_413 = ")){";
  protected final String TEXT_414 = NL + "                                                ";
  protected final String TEXT_415 = ".";
  protected final String TEXT_416 = " =null;" + NL + "                                            }else if(xml_api_";
  protected final String TEXT_417 = ".isEmpty(node_";
  protected final String TEXT_418 = ") || xml_api_";
  protected final String TEXT_419 = ".isMissing(node_";
  protected final String TEXT_420 = ")){";
  protected final String TEXT_421 = NL + "                                                ";
  protected final String TEXT_422 = ".";
  protected final String TEXT_423 = "=";
  protected final String TEXT_424 = ";" + NL + "                                            }else{";
  protected final String TEXT_425 = NL + "                                            if(xml_api_";
  protected final String TEXT_426 = ".isMissing(node_";
  protected final String TEXT_427 = ") || xml_api_";
  protected final String TEXT_428 = ".isEmpty(node_";
  protected final String TEXT_429 = ")){";
  protected final String TEXT_430 = NL + "                                                ";
  protected final String TEXT_431 = ".";
  protected final String TEXT_432 = " =";
  protected final String TEXT_433 = ";" + NL + "                                            }else{";
  protected final String TEXT_434 = NL + "                                        ";
  protected final String TEXT_435 = ".";
  protected final String TEXT_436 = " = str_";
  protected final String TEXT_437 = ";";
  protected final String TEXT_438 = NL + "                                            ";
  protected final String TEXT_439 = ".";
  protected final String TEXT_440 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_441 = ", ";
  protected final String TEXT_442 = ",false);";
  protected final String TEXT_443 = NL + "                                            ";
  protected final String TEXT_444 = ".";
  protected final String TEXT_445 = " = ParserUtils.parseTo_Date(str_";
  protected final String TEXT_446 = ", ";
  protected final String TEXT_447 = ");";
  protected final String TEXT_448 = "                          ";
  protected final String TEXT_449 = NL + "                                        ";
  protected final String TEXT_450 = ".";
  protected final String TEXT_451 = " = str_";
  protected final String TEXT_452 = ".getBytes(";
  protected final String TEXT_453 = ");";
  protected final String TEXT_454 = NL + "                                        ";
  protected final String TEXT_455 = ".";
  protected final String TEXT_456 = " = ParserUtils.parseTo_";
  protected final String TEXT_457 = "(ParserUtils.parseTo_Number(str_";
  protected final String TEXT_458 = ", ";
  protected final String TEXT_459 = ", ";
  protected final String TEXT_460 = "));";
  protected final String TEXT_461 = NL + "                                        ";
  protected final String TEXT_462 = ".";
  protected final String TEXT_463 = " = ParserUtils.parseTo_";
  protected final String TEXT_464 = "(str_";
  protected final String TEXT_465 = ");";
  protected final String TEXT_466 = NL + "                                            }";
  protected final String TEXT_467 = NL + "                        ";
  protected final String TEXT_468 = " = null; ";
  protected final String TEXT_469 = NL + "            " + NL + "                } catch (java.lang.Exception e_";
  protected final String TEXT_470 = ") {" + NL + "                    whetherReject_";
  protected final String TEXT_471 = " = true;";
  protected final String TEXT_472 = NL + "                        throw(e_";
  protected final String TEXT_473 = ");";
  protected final String TEXT_474 = NL + "                            ";
  protected final String TEXT_475 = " = new ";
  protected final String TEXT_476 = "Struct();";
  protected final String TEXT_477 = NL + "                                ";
  protected final String TEXT_478 = ".";
  protected final String TEXT_479 = " = ";
  protected final String TEXT_480 = ".";
  protected final String TEXT_481 = ";";
  protected final String TEXT_482 = NL + "                            ";
  protected final String TEXT_483 = ".errorMessage = e_";
  protected final String TEXT_484 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_485 = ";";
  protected final String TEXT_486 = NL + "                            ";
  protected final String TEXT_487 = " = null;";
  protected final String TEXT_488 = NL + "                            System.err.println(e_";
  protected final String TEXT_489 = ".getMessage());";
  protected final String TEXT_490 = NL + "                            ";
  protected final String TEXT_491 = " = null;";
  protected final String TEXT_492 = NL + "                            ";
  protected final String TEXT_493 = ".errorMessage = e_";
  protected final String TEXT_494 = ".getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_495 = ";";
  protected final String TEXT_496 = NL + "                }";
  protected final String TEXT_497 = "if(!whetherReject_";
  protected final String TEXT_498 = ") { ";
  protected final String TEXT_499 = "      " + NL + "                                 if(";
  protected final String TEXT_500 = " == null){ ";
  protected final String TEXT_501 = NL + "                                     ";
  protected final String TEXT_502 = " = new ";
  protected final String TEXT_503 = "Struct();" + NL + "                                 }";
  protected final String TEXT_504 = NL + "                                    ";
  protected final String TEXT_505 = ".";
  protected final String TEXT_506 = " = ";
  protected final String TEXT_507 = ".";
  protected final String TEXT_508 = ";                 ";
  protected final String TEXT_509 = " } ";
  protected final String TEXT_510 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

String cid = node.getUniqueName();

boolean readByXPath = "true".equals(ElementParameterParser.getValue(node, "__READBYXPATH__"));
String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String useUrl = ElementParameterParser.getValue(node, "__USEURL__");
boolean isUseUrl = "true".equals(useUrl);
String urlpath = ElementParameterParser.getValue(node, "__URLPATH__");

if(!readByXPath){
//--------------------start Read By JSON Path
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
List< ? extends IConnection> conns = NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA);
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				for (int i=0;i<mapping.size();i++) {
    				if(i % 100 == 0){

    stringBuffer.append(TEXT_3);
    stringBuffer.append((i/100) );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    
    				}

    
                        for(IMetadataColumn column:columns) {
                            if (mapping.get(i).get("SCHEMA_COLUMN")!=null) {
                                if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) {
    								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    		
                                        if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    		
                                        } else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_24);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_30);
    		
                                        }else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_31);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_39);
    
                                        } else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_40);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_46);
    
                                        } else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
                                        }

    stringBuffer.append(TEXT_54);
    
                                        String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
                                        if(defaultValue == null) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_57);
    
                                        } else {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_61);
    
                                        }

    stringBuffer.append(TEXT_62);
    

                                }
                            }
					   }
    				if((i + 1) % 100 == 0){

    stringBuffer.append(TEXT_63);
    
    				}
				} // for (int i=0)
  				if(mapping.size() > 0 && mapping.size() % 100 > 0){

    stringBuffer.append(TEXT_64);
    
 				 }
			}

		}

	}
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    if(!isUseUrl){//read from a file
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    }else{ //read from internet
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    if(!isUseUrl){//read from a file
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_93);
    }else{ //read from internet
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if(!isUseUrl) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_107);
    } else {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    if (dieOnError) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    }
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    
    	for(Map<String,String> path:mapping){
    		String column = path.get("SCHEMA_COLUMN");
    		String query = path.get("QUERY");

    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    
		}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		List<IMetadataColumn> columns=metadata.getListColumns();
		if (conns!=null) {
            String rejectConnName = "";
            List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
            if(rejectConns != null && rejectConns.size() > 0) {
                IConnection rejectConn = rejectConns.get(0);
                rejectConnName = rejectConn.getName();
            }
            List<IMetadataColumn> rejectColumnList = null;
            IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
            if(metadataTable != null) {
                rejectColumnList = metadataTable.getListColumns();      
            }
            for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_137);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_138);
    
				}
    		}
			if (conns.size()>0) { // conns.size()>0	
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for DATA

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_142);
    
            			for (int i=0;i<mapping.size();i++) {
            				if(i % 100 == 0){

    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append( (i/100) );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
    				        }
            			}// for
 						if(rejectConnName.equals(firstConnName)) {

    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_151);
    
                        }

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
                        if (dieOnError) {

    stringBuffer.append(TEXT_154);
    
                        } else {
                            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_157);
    
                                for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_162);
    
                            	}

    stringBuffer.append(TEXT_163);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_167);
    
                            } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_168);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_170);
    
                            }else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_171);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_173);
    
                            }
                        }

    stringBuffer.append(TEXT_174);
    
                }// end for DATA
			}// conns.size()>0
		} // if(conns!=null)
	} // if (metadata!=null)
} // if ((metadatas!=null)&&(metadatas.size()>0))

    
//---------------------end Read By JSON Path

}else{

//---------------------start Read By XPath
List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPINGXPATH__");
String loopQuery = ElementParameterParser.getValue(node, "__LOOP_QUERY__"); 

String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;

    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    
        String nodeChecked = null;
        boolean hasNodeCheck = false;
        for(int i = 0 ;i<mapping.size();i++){
            nodeChecked = mapping.get(i).get("NODECHECK");
            if("true".equals(nodeChecked)){
                hasNodeCheck = true;
                break;
            }
        }
        if(hasNodeCheck){

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
        }

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
			if (dieOnError) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    			
			}else{

    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    
			}

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(loopQuery );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_217);
    
				if(!isUseUrl){//read from a file

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_221);
    
				}else{ //read from internet

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(urlpath );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_229);
    
				}

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
            if (dieOnError) {

    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    
            }else{

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
     
            }

    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
            for (int i=0;i<mapping.size();i++) {
                String query = mapping.get(i).get("QUERY");

    stringBuffer.append(TEXT_295);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
            }

    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String firstConnName = "";
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        List<IMetadataColumn> columns=metadata.getListColumns();
        if (conns!=null) {
            String rejectConnName = "";
            List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
            if(rejectConns != null && rejectConns.size() > 0) {
                IConnection rejectConn = rejectConns.get(0);
                rejectConnName = rejectConn.getName();
            }
            List<IMetadataColumn> rejectColumnList = null;
            IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
            if(metadataTable != null) {
                rejectColumnList = metadataTable.getListColumns();      
            }
            for (int i=0;i<conns.size();i++) {
                IConnection connTemp = conns.get(i);
                if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_306);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_307);
    
                }
            }
            if (conns.size()>0) { // S_if_a_0_0     
                IConnection conn = conns.get(0);
                firstConnName = conn.getName();
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // add for reject

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_312);
    
                    for (int i=0;i<mapping.size();i++) { // S_for_a_1_0
                        String query = mapping.get(i).get("QUERY");
                        String nodeCheck = mapping.get(i).get("NODECHECK");
                        if("true".equals(nodeCheck) && query!=null){
                            if((".").equals(query.substring(1,query.length()-1)) && ("/").equals(loopQuery.substring(1,loopQuery.length()-1))){

    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    
                            }
                        }

    stringBuffer.append(TEXT_315);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_325);
    
                            }else{

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    
                            }

    stringBuffer.append(TEXT_328);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
                            }else{

    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    
                            }

    stringBuffer.append(TEXT_345);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    
                            if(("true").equals(nodeCheck)){

    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
                            }else{

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    
                            }

    stringBuffer.append(TEXT_377);
    
                        for(IMetadataColumn column:columns) {  // S_for_0_1
                            if (mapping.get(i).get("SCHEMA_COLUMN")!=null) { // S_if_0_2
                                if (column.getLabel().compareTo(mapping.get(i).get("SCHEMA_COLUMN"))==0) { // S_if_0_3
                                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                                    JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                                    String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                                    
                                    boolean isNotSetDefault = false;
                                    String defaultValue=column.getDefault();
                                    if(defaultValue!=null){
                                        isNotSetDefault = defaultValue.length()==0;
                                    }else{
                                        isNotSetDefault=true;
                                    }
                                    
                                    if("true".equals(nodeCheck)){

    stringBuffer.append(TEXT_378);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    
                                        continue;
                                    }
                                    if(javaType == JavaTypesManager.STRING){
                                        if(column.isNullable()){

    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_398);
    
                                        }else{ // column.isNullable()

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_410);
    
                                        }
                                    }else{ // other type
                                        if(column.isNullable()){

    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_415);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(isNotSetDefault?null:column.getDefault());
    stringBuffer.append(TEXT_424);
    
                                        }else{ // column.isNullable()

    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(isNotSetDefault?JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate):column.getDefault());
    stringBuffer.append(TEXT_433);
    
                                        }
                                    }
                                
                                    if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_434);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    
                                    } else if (javaType == JavaTypesManager.DATE) {
                                        if(checkDate) {

    stringBuffer.append(TEXT_438);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_442);
      
                                        } else {

    stringBuffer.append(TEXT_443);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_447);
                                          
                                        }
                                    } else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_448);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_453);
    
                                    } else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_454);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_456);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_459);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_460);
    
                                    } else {

    stringBuffer.append(TEXT_461);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    
                                    }

    stringBuffer.append(TEXT_466);
    
                                } //S_if_1_2
                            } // S_if_1_1
                        } // S_for_1_0
                    } // S_for_a_0_1

    
                    if(rejectConnName.equals(firstConnName)) {

    stringBuffer.append(TEXT_467);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_468);
    
                    }

    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    
                    if (dieOnError) {

    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    
                    } else {
                        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
    

    stringBuffer.append(TEXT_474);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_476);
    
                            for(IMetadataColumn column : metadata.getListColumns()) {

    stringBuffer.append(TEXT_477);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_479);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_481);
    
                            }

    stringBuffer.append(TEXT_482);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_487);
    
                        } else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_491);
    
                        } else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_492);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_495);
    
                        }
                    }

    stringBuffer.append(TEXT_496);
    
                } //if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))
            } // S_if_a_1_1

                if (conns.size()>0) {   
                    boolean isFirstEnter = true;
                    for (int i=0;i<conns.size();i++) {
                        IConnection tmpconn = conns.get(i);
                        if ((tmpconn.getName().compareTo(firstConnName)!=0)&&(tmpconn.getName().compareTo(rejectConnName)!=0)&&(tmpconn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

     
                            if(isFirstEnter) {
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
     isFirstEnter = false; } 

    stringBuffer.append(TEXT_499);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_503);
    
                                for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_504);
    stringBuffer.append(tmpconn.getName() );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_508);
    
                                }
                            }
                        }

     if(!isFirstEnter) {
    stringBuffer.append(TEXT_509);
     
                    }
                }

        }// if(conn!=null)
        
    }// if (metadata!=null)
}//if ((metadatas!=null)&&(metadatas.size()>0))
//--------------------end Read By XPath
}

    stringBuffer.append(TEXT_510);
    return stringBuffer.toString();
  }
}
