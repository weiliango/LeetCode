public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    public class Pos {
        int x;
        int y;
        public Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int width;
    int height;
    int length;
    int [][] food;
    boolean [] isEaten;
    Queue <Pos> snake = new LinkedList<Pos>();
    Pos head;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.isEaten = new boolean[food.length];
        this.length = 0;
        this.snake.clear();
        this.snake.add(new Pos(0,0));
        this.head = new Pos(0,0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Pos head = this.head;
        Pos next;
        if ( direction.charAt(0) == 'U' ) {
            next = new Pos(head.x-1, head.y);
        } else if ( direction.charAt(0) == 'L' ) {
            next = new Pos(head.x, head.y-1);
        } else if ( direction.charAt(0) == 'R') {
            next = new Pos(head.x, head.y+1);
        } else {
            next = new Pos(head.x+1, head.y);
        }

        Pos tail = snake.peek();

        if ( snake.contains(next) 
            || next.x < 0 || next.x >= height 
            || next.y < 0 || next.y >= width) {
            
            if( !next.equals(tail) ) 
                return -1;
        }

        snake.add(next);
        this.head = next;

        // System.out.println(next.x);
        // System.out.println(next.y);
        if ( length == food.length ) {
            snake.poll();
            return length;
        }
        if ( food[length][0] == next.x && food[length][1] == next.y && !isEaten[length]) {
            isEaten[length] = true;
            // snake.add(tail);
            length++;
            return length;
        }
        
        snake.poll();
        return length;

    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */