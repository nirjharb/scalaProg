object tictactoe {

  var a = Array.ofDim[Char](3, 3)
  var currentPlayerMark: Char = 'X'
  var Player1: String = ""
  var Player2: String = ""

  // Set/Reset the board back to all empty values.
  def initializeBoard() {

    // Loop through rows
    var q = 1
    for (i <- 0 to 2) {

      // Loop through columns
      for (j <- 0 to 2) {
        //var data:Char = q + 'O'
        a(i)(j) = (q + '0').toChar
        q += 1
      }
    }
  }


  def findElementPosition(element: String): String = {
    for (i <- 0 to 2) {

      // Loop through columns
      for (j <- 0 to 2) {
        if (a(i)(j).toString.equals(element) ) {
         // println("**"+i+"****"+j)
          var result:String=i+","+j
          return result
        }
        //return " "
      }
    }
    return " "
  }

    // Print the current board (may be replaced by GUI implementation later)
    def printBoard() {
      println("-------------")

      for (i <- 0 to 2) {
        print("| ")
        for (j <- 0 to 2) {
          print(a(i)(j) + " | ")
        }
        println()
        println("-------------")
      }
    }

    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    def isBoardFull(): Boolean = {
      var isFull = true

      for (i <- 0 to 2) {
        for (j <- 0 to 2) {
          if (!a(i)(j).isDigit) {
            isFull = false
          }
        }
      }

      return isFull
    }

    def checkForWin(): Boolean = {
      return (checkRowsForWin || checkColumnsForWin || checkDiagonalsForWin)
    }

    // Loop through rows and see if any are winners.
    def checkRowsForWin(): Boolean = {
      for (i <- 0 to 2) {
        if (checkRowCol(a(i)(0), a(i)(1), a(i)(2)) == true) {
          return true
        }
      }
      return false
    }

    // Loop through columns and see if any are winners.
    def checkColumnsForWin(): Boolean = {
      for (i <- 0 to 2) {
        if (checkRowCol(a(0)(i), a(1)(i), a(2)(i)) == true) {
          return true
        }
      }
      return false
    }

    // Check the two diagonals to see if either is a win. Return true if either wins.
    def checkDiagonalsForWin() = {
      ((checkRowCol(a(0)(0), a(1)(1), a(2)(2)) == true) || (checkRowCol(a(0)(2), a(1)(1), a(2)(0)) == true))
    }

    // Check to see if all three values are the same (and not empty) indicating a win.
    def checkRowCol(c1: Int, c2: Int, c3: Int): Boolean = {
      return ((c1 == c2) && (c2 == c3))
    }

    // Change player marks back and forth.
    def changePlayer() = {
      if (currentPlayerMark == 'X') {
        currentPlayerMark = 'O'
      }
      else {
        currentPlayerMark = 'X'
      }
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    def placeMark(row: Int, col: Int): Boolean = {

      // Make sure that row and column are in bounds of the board.
      if ((row >= 0) && (row < 3)) {
        if ((col >= 0) && (col < 3)) {
          if (a(row)(col) isDigit) {
            a(row)(col) = currentPlayerMark
            return true
          }
        }
      }

      return false
    }
    def main(args: Array[String]): Unit = {
      println("Enter name for Player 1: ")
      Player1 = Console.readLine()
      println("Enter name for Player 2: ")
      Player2 = Console.readLine()
      println("Players are :" + Player1 + "  ****  " + Player2)
      initializeBoard()
      printBoard()
      println( "Hey "+ Player1+" please enter choice ")
      var input1: String = Console.readLine()
      var result1 :String = findElementPosition(input1)
      placeMark(result1.split(",")(0).toInt,result1.split(",")(1).toInt)
      printBoard()
      changePlayer()
      println("Hey "+ Player2+" please enter your choice ")
      var input2: String = Console.readLine()
      var result2 :String = findElementPosition(input2)
      placeMark(result2.split(",")(0).toInt,result2.split(",")(1).toInt)
      printBoard()
      changePlayer()
      println( "Hey "+ Player1+" please enter your choice ")
      var input3: String = Console.readLine()
      var result3 :String = findElementPosition(input3)
      placeMark(result3.split(",")(0).toInt,result3.split(",")(1).toInt)
      printBoard()
      changePlayer()
      println( "Hey "+ Player2+" please enter your choice ")
      var input4: String = Console.readLine()
      var result4 :String = findElementPosition(input4)
      placeMark(result4.split(",")(0).toInt,result4.split(",")(1).toInt)
      printBoard()
      changePlayer()
      println( "Hey "+ Player1+" please enter your choice ")
      var input5: String = Console.readLine()
      var result5 :String = findElementPosition(input5)
      placeMark(result5.split(",")(0).toInt,result5.split(",")(1).toInt)
      printBoard()
      changePlayer()
      println( "Hey "+ Player2+" please enter your choice ")
      printBoard()
      var input6: String = Console.readLine()
      var result6 :String = findElementPosition(input6)
      placeMark(result6.split(",")(0).toInt,result6.split(",")(1).toInt)
      printBoard()

      // Did we have a winner?
      if (checkForWin()) {
        println("We have a winner! Congrats!" )
        System.exit(0)
      }
      else if (isBoardFull()) {
        println("Appears we have a draw!")
        System.exit(0)
      }
      // No winner or draw, switch players to 'O'

    }
  }
