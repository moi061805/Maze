package view;

import mod.Maze;
import mod.Minotaur;
import mod.Player;

public class StringMap {
  private final String _wall = "H";
  
  private final String _path = "O";
  
  private final String _ply = "P";
  
  private final String _min = "M";
  
  private final String _exit = "E";
  
  private final String _space = "     ";
  
  private final String _sword = "S";
  
  private Maze _maze;
  
  private Player _plyr;
  
  private Minotaur _mint;
  
  public StringMap(Maze m, Player p, Minotaur t) {
    this._maze = m;
    this._plyr = p;
    this._mint = t;
  }
  
  public String generateMap() {
    String map = "";
    for (int r = 0; r < (this._maze.getMaze()).length; r++) {
      for (int c = 0; c < (this._maze.getMaze()[0]).length; c++) {
        if (this._plyr.getRow() == r && this._plyr.getCol() == c) {
          map = String.valueOf(map) + "P     ";
        } else if (this._mint.getRow() == r && this._mint.getCol() == c) {
          map = String.valueOf(map) + "M     ";
        } else if (this._maze.getExit()[0] == r && this._maze.getExit()[1] == c) {
          map = String.valueOf(map) + "E     ";
        } else if (this._maze.getSword()[0] == r && this._maze.getSword()[1] == c) {
          map = String.valueOf(map) + "S     ";
        } else if (this._maze.getMaze()[r][c]) {
          map = String.valueOf(map) + "O     ";
        } else {
          map = String.valueOf(map) + "H     ";
        } 
      } 
      map = String.valueOf(map) + "\n";
    } 
    map = String.valueOf(map) + "\n";
    return map;
  }
}
