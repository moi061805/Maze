package mod;

import cont.JOP;
import javax.swing.JOptionPane;
import view.StringMap;

public class World {
  //This class create the world of the maze
  private Player _p;
  
  private Minotaur _t;
  
  private Maze _m;
  
  private StringMap _s;
  
  boolean _stopGame;
  
  int _stepCounter;
  
  public World() {
    this._stopGame = false;
    this._stepCounter = 0;
    this._m = new Maze();
    this._p = new Player(this._m.getPlyStart()[0], this._m.getPlyStart()[1]);
    this._t = new Minotaur(this._m.getMinStart()[0], this._m.getMinStart()[1]);
    this._s = new StringMap(this._m, this._p, this._t);
    update();
  }
  //This method sets the map that is chosen
  public void setMap() {
    int action = JOptionPane.showConfirmDialog(null, "   Yes = Map 1      No = Map 2      Cancel = Map 3   ", "Chose a Maze", 1);
    if (action == 0) {
      this._m._map = this._m.getcurMap()[0];
    } else if (action == 1) {
      this._m._map = this._m.getcurMap()[1];
    } else if (action == 2) {
      this._m._map = this._m.getcurMap()[2];
    } else {
      JOP.msg("Bye");
    } 
  }
  //This method updates the map everytime the player moves
  public void update() {
    JOP.msg("The objective is to get out of the maze without letting the minotaur get you. You can kill the minotaur by finding the sword and killing him.You can chage maps using the 'change' keyword.");
    setMap();
    boolean isPlaying = true;
    while (isPlaying) {
      boolean on = true;
      String map = this._s.generateMap();
      String msg = "WASD to move. What direction do you want to move?";
      while (on) {
        String move = JOP.in(String.valueOf(map) + msg);
        if (move != null)
          if (getPlayerMove(move))
            on = false;  
      } 
      if (giveSword())
        JOP.msg("You got the sword. Now go kill some minotaurs"); 
      if (victory()) {
        isPlaying = false;
        JOP.msg("Victory!!! :D");
      } 
      moveMinotaur();
      if (kill()) {
        isPlaying = true;
        JOP.msg("Assasin!!");
      } 
      if (death()) {
        isPlaying = false;
        JOP.msg("Game Over :(");
      } 
      if (this._stopGame) {
        isPlaying = false;
        this._stopGame = false;
      } 
    } 
  }
  //This method gets were the player is moving
  private boolean getPlayerMove(String s) {
    if (s.equalsIgnoreCase("W")) {
      if (this._p.getRow() - 1 >= 0 && this._m.getMaze()[this._p.getRow() - 1][this._p.getCol()]) {
        this._p.setPos(this._p.getRow() - 1, this._p.getCol());
        this._stepCounter++;
        return true;
      } 
      return false;
    } 
    if (s.equalsIgnoreCase("S")) {
      if (this._p.getRow() + 1 < (this._m.getMaze()).length && this._m.getMaze()[this._p.getRow() + 1][this._p.getCol()]) {
        this._p.setPos(this._p.getRow() + 1, this._p.getCol());
        this._stepCounter++;
        return true;
      } 
      return false;
    } 
    if (s.equalsIgnoreCase("D")) {
      if (this._p.getCol() + 1 < (this._m.getMaze()[0]).length && this._m.getMaze()[this._p.getRow()][this._p.getCol() + 1]) {
        this._p.setPos(this._p.getRow(), this._p.getCol() + 1);
        this._stepCounter++;
        return true;
      } 
      return false;
    } 
    if (s.equalsIgnoreCase("A")) {
      if (this._p.getCol() - 1 >= 0 && this._m.getMaze()[this._p.getRow()][this._p.getCol() - 1]) {
        this._p.setPos(this._p.getRow(), this._p.getCol() - 1);
        this._stepCounter++;
        return true;
      } 
      return false;
    } 
    if (s.equalsIgnoreCase("change")) {
      this._stepCounter = 0;
      this._stopGame = true;
      this._p.setPos(0, 2);
      this._t.setPos(5, 9);
      update();
    } 
    return false;
  }
  //This method moves the minotaur
  private void moveMinotaur() {
    int rDist = this._p.getRow() - this._t.getRow();
    int cDist = this._p.getCol() - this._t.getCol();
    int r = this._t.getRow();
    int c = this._t.getCol();
    if (rDist < 0 && this._m.getMaze()[r - 1][c])
      this._t.setPos(r - 1, c); 
    if (rDist > 0 && this._m.getMaze()[r + 1][c])
      this._t.setPos(r + 1, c); 
    if (cDist > 0 && this._m.getMaze()[r][c + 1])
      this._t.setPos(r, c + 1); 
    if (cDist < 0 && this._m.getMaze()[r][c - 1])
      this._t.setPos(r, c - 1); 
  }
  //This method displays how many steps you walked
  public boolean death() {
    if (this._t.getRow() == this._p.getRow() && 
      this._t.getCol() == this._p.getCol()) {
      JOP.msg("You walked " + Integer.toString(this._stepCounter) + " steps.");
      return true;
    } 
    return false;
  }
  //This method shows a victory message and shows how many steps you took
  public boolean victory() {
    if (this._p.getRow() == this._m.getExit()[0] && this._p.getCol() == this._m.getExit()[1]) {
      JOP.msg("You walked " + Integer.toString(this._stepCounter) + " steps.");
      return true;
    } 
    return false;
  }
  //This method gives the sword to the player
  public boolean giveSword() {
    if (this._p.getRow() == this._m.getSword()[0] && this._p.getCol() == this._m.getSword()[1]) {
      this._p.giveSword();
      return true;
    } 
    return false;
  }
  //This method kills the minotaur
  public boolean kill() {
    if (this._p.hasSword() && this._t.getRow() == this._p.getRow() && this._t.getCol() == this._p.getCol()) {
      this._t.setPos(12, 0);
      return true;
    } 
    return false;
  }
}
