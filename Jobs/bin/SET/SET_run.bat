%~d0
 cd %~dp0
 java -Xms256M -Xmx1024M -cp ../lib/jnp-client.jar;../lib/slf4j-simple-1.5.4.jar;../lib/javassist.jar;../lib/log4j-1.2.13.jar;../lib/talend_file_enhanced_20070724.jar;../lib/trove.jar;../lib/jboss-messaging-client.jar;../lib/toplink-essentials.jar;../lib/das_server.jar;../lib/dom4j-1.6.1.jar;../lib/xmlrpc-1.1.1.jar;../lib/talendcsv.jar;../lib/activemq-all-5.5.0.jar;../lib/OpenDAS_xmlrpc1.jar;../lib/systemRoutines.jar;../lib/userRoutines.jar;.;set_0_1.jar; opendas.set_0_1.SET --context=Default %* 