import org.simpleflatmapper.csv.CsvParser
import java.nio.charset.StandardCharsets.UTF_8
import java.nio.file.Files.newBufferedReader
import java.nio.file.Paths
import kotlin.streams.toList

fun main(args: Array<String>) {
    val input = newBufferedReader(Paths.get("test.csv"), UTF_8);

    val lines = input.use {
        CsvParser
                .skip(1)
                .mapTo(CsvLine::class.java)
                .addMapping("field1")
                .addMapping("field2")
                .stream(it)
                .toList()
    }

    println("Total lines read: ${lines.size}")
}