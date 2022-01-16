import java.util.HashMap;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class rolesAndScenario {
    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        HashMap<String, ArrayList<String>> roles_phrases = new HashMap<>();
        for (String role : roles) {
            roles_phrases.put(role, new ArrayList<>());
        }

        Pattern pattern = Pattern.compile(":");
        for (int i = 0; i < textLines.length; i++) {
            String[] roleName = pattern.split(textLines[i],2);
            roles_phrases.get(roleName[0]).add(String.format("%1$s)" + "%2$s", i + 1, roleName[1]));
        }
        String answer = "";
        for (String role : roles) {
            answer = answer + role + ":" + "\n";
            for (int i = 0; i < roles_phrases.get(role).size(); i++) {
                answer = answer + roles_phrases.get(role).get(i) + "\n";
            }
            answer = answer + "\n";
        }
        System.out.println((answer == null || answer.length() == 0) ? null : (answer.substring(0, answer.length() - 2)));
    }
}