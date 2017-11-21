public class Generator {

    private int[] symbol = {33, 34, 252, 59, 37, 58, 63, 42, 40, 41, 95, 43, 61, 45, 126, 47, 92, 60, 62, 44, 46, 91, 93, 123, 125};

    String ramndom(int passLength){
        String password = "";
        for (int i = 0; i < passLength; i++) {
            char c;
            int g = (int) (Math.random() * 4);
            if (g == 1) {
                c = (char) ((int) (48 + (Math.random() * 10)));
            } else if (g == 2){
                c = (char) symbol[(int) (Math.random() * 25)];
            } else if (g == 3) {
                c = (char) ((int) (65 + (Math.random() * 25)));
            } else {
                c = (char) ((int) (97 + (Math.random() * 25)));
            }
            password = password+ c;
        }

        return password;
    }
}

// !"№;%:?*()_+=-~/\<>,.[]{}   (33/34/252/59/37/58/63/42/40/41/95/43/61/45/126/47/92/60/62/44/46/91/93/123/125)
// 1234567890                   (48-57)
// ABCDEFGHIJKLMNOPQRSTUVWXYZ   (65-90)
// abcdefghijklmnopqrstuvwxyz   (97-122)
// lowercase / uppercase