package mod;

public class Maze {
  private boolean[][] _curMaze = new boolean[][] { 
      { true, true, true, true, true, true }, { false, true, true, true, true, true, true }, { false, false, true, true, true, true, true, true, true, true }, { false, false, true, true, true, true, true, true }, { false, false, true, true, true, true, true, true }, { true, true, true, true, true, true, true, true, true }, { false, false, true, true, true, true, true }, { false, false, true, true, true, true }, { false, false, true, true, true, true, true, true }, { false, false, false, false, false, false, false, true, true }, 
      { false, false, false, false, false, false, false, true, true }, { 
        false, false, false, false, false, false, false, false, false, true, 
        true, true }, { 
        false, false, false, false, false, false, false, true, true, true, 
        true, true } };
  
  private boolean[][] _curMaze2 = new boolean[][] { 
      { true, true, true, true, true, true }, { true, true, true, true, true, true, true }, { true, true, true, true, true, true, true, true, true }, { true, true, true, true, true, true }, { true, true, true, true, true, true, true }, { true, true, true, true, true, true, true }, { true, true, true, true, true }, { true, true, true, true, true, true, true, true }, { true, true, true, true, true, true, true, true }, { true, true, true, true, true, true }, 
      { false, false, false, true, true, true, true, true }, { 
        false, false, false, false, false, false, false, false, false, false, 
        false, true }, { 
        false, false, false, false, false, false, false, false, false, false, 
        false, true } };
  
  private boolean[][] _curMaze3 = new boolean[][] { 
      { true, true, true, true }, { true, true, true, true, true }, { 
        true, true, true, true, true, true, true, true, true, true, 
        true }, { true, true, true, true, true, true }, { true, true, true }, { true, true, true, true, true, true, true, true }, { true, true, true, true, true, true, true, true, true }, { true, true, true, true, true, true, true }, { true, true, true, true, true, true }, { true, true, true, true, true, true }, 
      { true, true, true, true, true, true, true }, { false, false, false, true, true, true, true }, { false, false, true, true, true, true, true, true, true, true } };
  
  private int[] _plyStartLocations = new int[2];
  
  private int[] _minStartLocations = new int[] { 0, 11 };
  
  private int[] _exit = new int[] { 12, 11 };
  
  private int[] _sword = new int[] { 5, 5 };
  
  public boolean[][] _map;
  
  public boolean[][] getMaze() {
    return this._map;
  }
  
  public int[] getPlyStart() {
    return this._plyStartLocations;
  }
  
  public int[] getMinStart() {
    return this._minStartLocations;
  }
  
  public int[] getExit() {
    return this._exit;
  }
  
  public int[] getSword() {
    return this._sword;
  }
  
  public boolean[][][] getcurMap() {
    return this._mazeList;
  }
  
  private boolean[][][] _mazeList = new boolean[][][] { this._curMaze, this._curMaze2, this._curMaze3 };
}