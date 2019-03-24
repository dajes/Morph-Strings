import java.util.ArrayList;

public class MorphString {
    private int pause ;
    private int[] max_sizes;
    private char[] values;
    private String x;
    private Visual panel;
    private int sum;
    MorphString(int pause){
        this.pause = pause;
    }
    private boolean _try(int[] cell_sizes){
        for(int i = 0; i < cell_sizes.length; i++){
            if(cell_sizes[i] > max_sizes[i]) return false;
        }
        StringBuilder tmp = new StringBuilder(), borders = new StringBuilder();
        for(int i = 0; i < cell_sizes.length; i++){
            for(int j = 0; j < cell_sizes[i]; j++)
            {
                if(j!=0 && pause > 0)
                    borders.append(" ");
                tmp.append(values[i]);
            }
            if(pause > 0)
                borders.append("|");
        }
        String tmp_s = tmp.toString();
        if(pause > 0) {
            panel.borders = borders.toString();
            panel.current = tmp_s;
        }
        StringBuilder greencurrent = new StringBuilder(),
                redcurrent = new StringBuilder(),
                greenx = new StringBuilder(),
                redx = new StringBuilder();
        for(int i = 0; i < tmp_s.length(); i++){
            if(x.charAt(i) != '1' && tmp_s.charAt(i) != x.charAt(i)) {
                panel.tries++;
                if(pause > 0) {
                    redcurrent.append(tmp_s.charAt(i));
                    redx.append(x.charAt(i));
                    panel.redx = redx.toString();
                    panel.redcurrent = redcurrent.toString();
                    panel.greencurrent = greencurrent.toString();
                    panel.greenx = greenx.toString();

                    sleep();
                }
                return false;
            } else {
                if(pause > 0) {
                    redcurrent.append(" ");
                    redx.append(" ");
                    greencurrent.append(tmp_s.charAt(i));
                    greenx.append(x.charAt(i));
                }
            }
        }
        panel.tries++;
        panel.greencurrent = tmp_s;
        panel.greenx = panel.x;
        if(pause > 0) {
            panel.redx = "";
            panel.redcurrent = "";
            sleep();
        }
        return true;
    }

    boolean check(String x, String y, Visual panel){
        this.panel = panel;
        this.x = x;
        panel.x = x;
        if(pause > 0)
            sleep();
        panel.y = y;
        if(pause > 0)
            sleep();

        char prev = ' ';

        ArrayList<Integer> bounds = new ArrayList<>();
        for(int i = 0; i < y.length(); i++){
            if(prev != y.charAt(i)){
                bounds.add(i);
                prev = y.charAt(i);
            }
            if(i == y.length()-1){
                bounds.add(y.length());
            }
        }
        max_sizes = new int[bounds.size()-1];
        values = new char[bounds.size()-1];
        for(int i = 0; i < max_sizes.length; i++){
            max_sizes[i] = bounds.get(i+1) - bounds.get(i);
            if(y.charAt(bounds.get(i)) == 'A') values[i] = '0';
            else values[i] = '1';
        }
        StringBuilder _y = new StringBuilder();
        for(int i = 0; i<values.length; i++){
            for(int j = 1; j < max_sizes[i];j++){
                _y.append(" ");
            }
            _y.append(values[i]);
        }
        panel._y = _y.toString();
        if(pause > 0)
            sleep();
        final int size = x.length();
        int[] cell_sizes = new int[max_sizes.length];
        sum = cell_sizes.length;
        for(int i = 0; i < cell_sizes.length; i++){
            cell_sizes[i] = 1;
        }
        if (sum == size)
            if (_try(cell_sizes)) return true;

        while (increment(0, cell_sizes)) {
            if (sum == size)
                if (_try(cell_sizes)) return true;
        }
        return false;
    }

    private boolean increment(int start, int[] cell_sizes){
        for(int i = start; i < cell_sizes.length; i++){
            if(cell_sizes[i] < max_sizes[i]){
                cell_sizes[i]++;
                sum++;
                return true;
            } else {
                sum -= max_sizes[i] - 1;
                cell_sizes[i] = 1;
                if(i+1 < cell_sizes.length)
                    return increment(i+1, cell_sizes);
                else return false;
            }
        }
        return false;
    }
    private void sleep(){
        sleep(pause);
    }
    private void sleep(int time){
        panel.repaint();
        try {
            Thread.sleep(time);
        } catch (Exception ignored){}
    }
}
