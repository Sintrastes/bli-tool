
//
// Logic for reading the configuration data.
//

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import scala.collection.mutable.ListBuffer
import java.io.{File, FileInputStream}
import scala.beans._

object Config {
  def getConfigData(): ConfigData =
    {
      val homeDir = System.getProperty("user.home")
      val configDirPath = homeDir + "/.bli-tool"
      println(configDirPath)
      val configDir = new File(configDirPath)
      val configPath = configDirPath + "/config.yaml"
      val inputFile = new File(configPath)
      if(!configDir.exists()) {
        val result = configDir.mkdir()
        println(result)
      }
      if (!inputFile.exists()) {
        inputFile.createNewFile()
      }
      val input = new FileInputStream(inputFile)
      val yaml = new Yaml(new Constructor(classOf[ConfigData]))
      return yaml.load(input).asInstanceOf[ConfigData]
    }
}

class ConfigData {
    @BeanProperty var ipAddress = ""
    @BeanProperty var portNumber = ""
}
