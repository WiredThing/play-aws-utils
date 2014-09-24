package fly.play.aws

import fly.play.aws.auth.{Aws4Signer, AwsCredentials}
import org.specs2.mutable.Specification
import play.api.test.FakeApplication
import testUtils.RunningFakePlayApplication
import play.api.Play.current

object AwsProxySpec extends Specification with RunningFakePlayApplication {
  override def f: FakeApplication = FakeApplication(new java.io.File("./src/test/proxyTest"))

  "example1" >> {

    val requestHolder =
      Aws.withSigner(signer).url("https://sts.amazonaws.com")

    val proxy = requestHolder.wrappedRequest.proxyServer

    "Proxy should be set on request" in {
      proxy must_!= None
    }

    "Proxy host should be set from config file" in {
      proxy.get.host must_== "proxy.example.com"
    }

    "Proxy port should be set from config file" in {
      proxy.get.port must_== 8080
    }
  }


  val credentials = AwsCredentials("AKIAIOSFODNN7EXAMPLE", "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY")
  val signer = new Aws4Signer(credentials, "sts", "us-east-1")


}
