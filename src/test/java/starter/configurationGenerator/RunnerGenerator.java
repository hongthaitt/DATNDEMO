//package starter.configurationGenerator;
//
//import com.squareup.javapoet.*;
//import io.cucumber.junit.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//import org.junit.BeforeClass;
//import org.junit.runner.RunWith;
//
//import javax.lang.model.element.Modifier;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
////auto gen file feature for another file feature
//
//public class RunnerGenerator {
//    public static void main(String[] args) throws IOException {
//        //get file feature
//
//        final File folder = new File("src\\test\\resources\\features\\consult_dictionary");
//        List<FileDetail> result = new ArrayList<>();
//        search(".*\\.feature", folder, result);
//        // auto gen file runner for another file feature
//        for (FileDetail s : result) {
//            String runnerName = s.name + "Runner";
//            String cucumberFormat = "{\"pretty\", \"json:target/" + s.name + ".json\"}";
//            TypeSpec runner = TypeSpec.classBuilder(runnerName)
//                    .addModifiers(Modifier.PUBLIC)
//                    .addAnnotation(AnnotationSpec.builder(RunWith.class).addMember("value", "$T.class", CucumberWithSerenity.class).build()).addAnnotation(AnnotationSpec.builder(CucumberOptions.class).addMember("features", "$S", s.path).addMember("plugin", "$L", cucumberFormat).build()).addMethod(MethodSpec.methodBuilder("initConfiguration").addModifiers(Modifier.PUBLIC, Modifier.STATIC).addAnnotation(AnnotationSpec.builder(BeforeClass.class).build()).addStatement("$T.setProperties($S)", ClassName.get(" starter.dataService", "TestDataService"), "\\src\\test\\resources\\data_test\\data.properties").build()).build();
//            JavaFile javaFile = JavaFile.builder("starter", runner)
//                    .build();
//            javaFile.writeTo(Paths.get("src/test/java"));
//        }
//    }
//
//    private static void search(final String pattern, final File folder, List<FileDetail> result) {
//        for (final File f : Objects.requireNonNull(folder.listFiles())) {
//
//            if (f.isDirectory()) {
//                search(pattern, f, result);
//            }
//
//            if (f.isFile()) {
//                if (f.getName().matches(pattern)) {
//                    String name = f.getName().replace(".feature", "");
//                    String path = f.getPath();
//                    FileDetail tempFile = new FileDetail(name, path);
//                    result.add(tempFile);
//                }
//            }
//
//        }
//    }
//
//    private static class FileDetail {
//        private String name;
//        private String path;
//
//        private FileDetail(String name, String path) {
//            this.name = name;
//            this.path = path;
//        }
//    }
//}
