import mooc.EdxIO;

public class WriteCodeTemplate {

    static final String TEMPLATE_START = "%TEMPLATE-START%";
    static final String TEMPLATE_END = "%TEMPLATE-END%";


    public static int dist(char[][] keyboard, char a, char b) {
        int ans = 0;
        int x = 0, y = 0, z = 0, w = 0;
        boolean flag = false;
        for(int i = 0; i < keyboard.length; i++) {
            for(int j = 0; j < keyboard[0].length; j++) {
                if(keyboard[i][j] == a) {
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        flag = false;

        for(int i = 0; i < keyboard.length; i++) {
            for(int j = 0; j < keyboard[0].length; j++) {
                if(keyboard[i][j] == b) {
                    z = i;
                    w = j;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        return Math.max(Math.abs(z-x), Math.abs(w-y));
    }

    public static int calculateTime(char[][] keyboard, String code) {

        int ans = 0;

        char[] codes = code.toCharArray();

        for(int i = 1; i < codes.length; i++) {
            ans += dist(keyboard, codes[i], codes[i-1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        try(EdxIO io = EdxIO.create()) {
            int w = io.nextInt();
            int h = io.nextInt();
            char[][] keyboard = new char[h][w];
            for(int i = 0; i < h; i++) {
                keyboard[i] = io.next().toCharArray();
            }
            String[] languages = new String[3];
            int[] lengths = new int[3];
            for(int i = 0; i < languages.length; i++) {
                languages[i] = io.next();

                StringBuilder code = new StringBuilder("");

                io.next();

                String line = io.next();

                while(!TEMPLATE_END.equals(line)) {
                    code.append(line);
                    line = io.next();
                }
                lengths[i] = calculateTime(keyboard, code.toString());
            }


            int min = Math.min(lengths[0], Math.min(lengths[1], lengths[2]));
            if(min == lengths[0]) {
                io.println(languages[0]);
                io.println(lengths[0]);
            } else if(min == lengths[1]) {
                io.println(languages[1]);
                io.println(lengths[1]);
            } else {
                io.println(languages[2]);
                io.println(lengths[2]);
            }
        }
    }

}
