package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;


/**
 * Draws a world that contains RANDOM tiles.
 */
public class RandomWorldDemo {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    /**
     * Fills the given 2D array of tiles with RANDOM tiles.
     * @param tiles
     */
    public static void fillWithRandomTiles(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = randomTile();
            }
        }
    }

    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0:
                return Tileset.WALL;
            case 1:
                return Tileset.FLOWER;
            case 2:
                return Tileset.NOTHING;
            default:
                return Tileset.NOTHING;
        }
    }

//    private static int hexRowWidth(int size, int row){
//        int truerow = row;
//        if(row>=size){
//            return 5*size-2-2*truerow;//size+2*(size-1)-2*(truerow-size);
//        }
//        return size+truerow*2;
//    }
//    public static int hexRowOffset(int size, int row) {
//        int effectiveI = row;
//        if (row >= size) {
//            effectiveI = 2 * size - 1 - effectiveI;
//        }
//        return -effectiveI;
//    }
//    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
//        for (int xi = 0; xi < width; xi += 1) {
//            int xCoord = p.x + xi;
//            int yCoord = p.y;
//            world[xCoord][yCoord] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
//        }
//    }
//    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
//
//        if (s < 2) {
//            throw new IllegalArgumentException("Hexagon must be at least size 2.");
//        }
//
//        // hexagons have 2*s rows. this code iterates up from the bottom row,
//        // which we call row 0.
//        for (int yi = 0; yi < 2 * s; yi += 1) {
//            int thisRowY = p.y + yi;
//
//            int xRowStart = p.x + hexRowOffset(s, yi);
//            Position rowStartP = new Position(xRowStart, thisRowY);
//
//            int rowWidth = hexRowWidth(s, yi);
//
//            addRow(world, rowStartP, rowWidth, t);
//
//        }
//    }


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        fillWithRandomTiles(randomTiles);
        //initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        ter.renderFrame(world);
    }


}
