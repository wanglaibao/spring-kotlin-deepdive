package io.spring.deepdive

import com.samskivert.mustache.Mustache.*

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import com.mongodb.connection.netty.NettyStreamFactoryFactory
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer



@SpringBootApplication
class Application {

    @Bean
    fun mustacheCompiler(loader: TemplateLoader) =
            compiler().escapeHTML(false).withLoader(loader)

    // @Bean
    fun clientSettingsBuilderCustomizer() =
            MongoClientSettingsBuilderCustomizer { it.streamFactoryFactory(NettyStreamFactoryFactory.builder().build()) }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}