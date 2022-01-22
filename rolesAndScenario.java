import java.util.HashMap;
import java.util.ArrayList;


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

        for (int i = 0; i < textLines.length; i++) {
            String[] roleName = textLines[i].split(":", 2);
            roles_phrases.get(roleName[0]).add(String.format("%1$s)" + "%2$s", i + 1, roleName[1]));
        }
        StringBuilder answer = new StringBuilder("");
        for (String role : roles) {
            answer.append(role).append(":").append("\n");
            for (int i = 0; i < roles_phrases.get(role).size(); i++) {
                answer.append(roles_phrases.get(role).get(i)).append("\n");
            }
            answer.append("\n");
        }
        System.out.println((answer == null || answer.length() == 0) ? null : (answer.substring(0, answer.length() - 2)));
    }
}
