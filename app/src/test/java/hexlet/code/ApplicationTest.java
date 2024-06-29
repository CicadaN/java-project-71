package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;
    private static String resultDefault;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("json.txt");
        resultPlain = readFixture("plain.txt");
        resultStylish = readFixture("stylish.txt");
        resultDefault = readFixture("default.txt");
    }

    @Test
    public void testJsonToJson() throws Exception {
        String filePatch1 = getFixturePath("file1.json").toString();
        String filePatch2 = getFixturePath("file2.json").toString();

        String expected = resultJson;
        String actual = Differ.generate(filePatch1, filePatch2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonToPlain() throws Exception {
        String filePatch1 = getFixturePath("file1.json").toString();
        String filePatch2 = getFixturePath("file2.json").toString();

        String expected = resultPlain;
        String actual = Differ.generate(filePatch1, filePatch2, "plain");
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }


    @Test
    public void testJsonToStylish() throws Exception {
        String filePatch1 = getFixturePath("file1.json").toString();
        String filePatch2 = getFixturePath("file2.json").toString();

        String expected = resultStylish;
        String actual = Differ.generate(filePatch1, filePatch2, "stylish");
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }

    @Test
    public void testJsonToDefault() throws Exception {
        String filePatch1 = getFixturePath("file1.json").toString();
        String filePatch2 = getFixturePath("file2.json").toString();

        String expected = resultDefault;
        String actual = Differ.generate(filePatch1, filePatch2);
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }

    @Test
    public void testYamlToJson() throws Exception {
        String filePatch1 = getFixturePath("file1.json").toString();
        String filePatch2 = getFixturePath("file2.json").toString();

        String expected = resultDefault;
        String actual = Differ.generate(filePatch1, filePatch2);
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }

    @Test
    public void testYamlToPlain() throws Exception {
        String filePatch1 = getFixturePath("file3.yaml").toString();
        String filePatch2 = getFixturePath("file4.yaml").toString();

        String expected = resultPlain;
        String actual = Differ.generate(filePatch1, filePatch2, "plain");
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }


    @Test
    public void testYamlToStylish() throws Exception {
        String filePatch1 = getFixturePath("file3.yaml").toString();
        String filePatch2 = getFixturePath("file4.yaml").toString();

        String expected = resultStylish;
        String actual = Differ.generate(filePatch1, filePatch2, "stylish");
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }

    @Test
    public void tesYamlToDefault() throws Exception {
        String filePatch1 = getFixturePath("file3.yaml").toString();
        String filePatch2 = getFixturePath("file4.yaml").toString();

        String expected = resultDefault;
        String actual = Differ.generate(filePatch1, filePatch2);
        assertEquals(expected.trim().replaceAll("\\s+", " "),
                actual.trim().replaceAll("\\s+", " "));
    }
}
