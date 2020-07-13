public class Game2048 {
    private int [][] grid;
    private int score = 0;


    public Game2048 (){
        grid = new int[4][4];
        this.initialize();
        this.casualSpawn();
    }

    public Game2048 (String difficulty){

        if (difficulty.equalsIgnoreCase("easy")){
            grid = new int[4][4];
        }
        if (difficulty.equalsIgnoreCase("medium")){
            grid = new int[6][6];
        }
        if (difficulty.equalsIgnoreCase("hard")){
            grid = new int[10][10];
        }
        if (difficulty.equalsIgnoreCase("insane")){
            grid = new int[20][20];
        }
        this.initialize();
        this.casualSpawn();
    }


    public void initialize (){
        for (int i = 0; i < this.grid.length; i ++){
            for (int j = 0; j < this.grid[i].length; j ++){
                this.grid [i][j] = 0;
            }
        }
    }

    public void casualSpawn(){

        while (true){
            int positionX = (int) (Math.random() *this.grid.length);
            int positionY = (int) (Math.random() *this.grid.length);
            if (this.grid [positionX][positionY] == 0){
                this.grid [positionX][positionY] = 2;
                break;
            }

        }
    }

    public void playerTurn (String direction){
        if (direction.equalsIgnoreCase("a")){
            for (int i = 0; i < this.grid.length; i ++){
                for (int j = 1; j < this.grid[i].length; j ++){
                    if (this.grid [i][j] != 0){
                        do {
                            if (this.grid[i][j - 1] == 0) {
                                this.grid[i][j - 1] = this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (j > 1) {
                                    j--;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i][j - 1]) {
                                this.grid[i][j - 1] += this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (j > 1) {
                                    j--;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i][j - 1] && this.grid[i][j] != 0) {
                                continue;
                            }

                        }while (this.grid [i][j - 1] == 0 );
                    }
                }
            }
        }



        if (direction.equalsIgnoreCase("d")){
            for (int i = 0; i < this.grid.length; i ++){
                for (int j = this.grid[i].length - 2; j >= 0; j --){
                    if (this.grid [i][j] != 0){
                        do {
                            if (this.grid[i][j + 1] == 0) {

                                this.grid[i][j + 1] = this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (j < this.grid[i].length - 2) {
                                    j++;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i][j + 1]) {
                                this.grid[i][j + 1] += this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (j < this.grid[i].length - 2) {
                                    j++;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i][j + 1] && this.grid[i][j] != 0) {
                                continue;
                            }

                        }while (this.grid [i][j + 1] == 0 );
                    }
                }
            }
        }



        if (direction.equalsIgnoreCase("s")){
            for (int i = this.grid.length - 2; i >= 0; i --){
                for (int j = this.grid[i].length - 1; j >= 0; j --){
                    if (this.grid [i][j] != 0){
                        do {
                            if (this.grid[i + 1][j] == 0) {

                                this.grid[i + 1][j] = this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (i < this.grid.length - 2) {
                                    i++;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i  + 1][j]) {
                                this.grid[i  + 1][j] += this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (i < this.grid.length - 2) {
                                    i++;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i  + 1][j] && this.grid[i][j] != 0) {
                                continue;
                            }

                        }while (this.grid [i  + 1][j] == 0 );
                    }
                }
            }
        }


        if (direction.equalsIgnoreCase("w")){
            for (int i = 1; i < this.grid.length ; i ++){
                for (int j = this.grid[i].length - 1; j >= 0; j --){
                    if (this.grid [i][j] != 0){
                        do {
                            if (this.grid[i - 1][j] == 0) {

                                this.grid[i - 1][j] = this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (i > 1) {
                                    i--;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i - 1][j]) {
                                this.grid[i - 1][j] += this.grid[i][j];
                                this.grid[i][j] = 0;
                                if (i > 1) {
                                    i--;
                                }
                            }
                            if (this.grid[i][j] == this.grid[i - 1][j] && this.grid[i][j] != 0) {
                                continue;
                            }

                        }while (this.grid [i - 1][j] == 0 );
                    }
                }
            }
        }

        this.score += 10;
        this.casualSpawn();
    }

    public int getScore (){
        return this.score;
    }

    public boolean isThereCombination (){
        //laterale
        for (int i = 0; i < this.grid.length; i ++){
            for (int j = 0; j < this.grid[i].length - 1; j ++){
                if (this.grid [i][j] == this.grid [i][j + 1]){
                    return true;
                }
            }
        }
        //verticale
        for (int i = 0; i < this.grid.length - 1; i ++){
            for (int j = 0; j < this.grid[i].length; j ++){
                if (this.grid[i][j] == this.grid [i + 1][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isLose(){
        int count = 0;
        for (int i = 0; i < this.grid.length; i ++){
            for (int j = 0; j < this.grid[i].length; j ++){
                if (this.grid[i][j] != 0){
                    count ++;
                }
            }
        }
        if (count == this.grid.length * this.grid.length && !this.isThereCombination()){
            return true;
        }
        return false;
    }

    public String toString (){
        String result = "";
        for (int i = 0 ; i < this.grid.length; i ++){
            result += "|";
            for (int j = 0; j < this.grid[i].length; j ++){
                if (this.grid[i][j] < 10){
                    if (this.grid[i][j] == 0){
                        result += "[   ]";
                    }else if (this.grid[i][j] == 2) {
                        result += "\u001B[47m\u001B[30m[ " + this.grid[i][j] + " ]\u001B[0m";
                    }
                    else if (this.grid[i][j] == 4) {
                        result += "\u001B[42m\u001B[34m[ " + this.grid[i][j] + " ]\u001B[0m";
                    }
                    else {result += "\u001B[41m\u001B[33m[ " + this.grid[i][j] + " ]\u001B[0m";}
                }
                else if (this.grid [i][j] < 100){
                    result += "\u001B[46m\033[0;31m[" + this.grid[i][j] +  " ]\u001B[0m";
                }
                else {
                    result += "[" + this.grid[i][j] +  "]";
                }
            }
            result += "|\n";
        }
        return result;
    }

}