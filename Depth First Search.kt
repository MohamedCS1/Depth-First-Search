import java.util.*

fun main() {

    val adj = arrayListOf<LinkedList<Int>>()

    // create AdjacencyList (Array of LinkedList)

    adj.add(LinkedList<Int>())
    adj[0].add(0)

    for (i in 1..6) {
        adj.add(LinkedList<Int>())
    }

    // add edges between node

    adj[1].add(2)
    adj[2].add(5)
    adj[2].add(4)
    adj[2].add(6)
    adj[3].add(1)
    adj[4].add(3)
    adj[5].add(6)
    adj[5].add(4)
    adj[6].add(4)

    // add Array to change state of node to visit

    val visited = arrayOfNulls<Boolean>(adj.size +  1)

    // stack to check if node have child

    val stack = Stack<Int>()

    for (i in 1..6)
    {
        visited[i] = false
    }

    fun dfs(startvertex:Int)
    {

        val patharry = arrayListOf<Int>()

        stack.push(startvertex)

        while (stack.isNotEmpty())
        {
            //current is top in stack

            val current = stack.pop()

            stack.push(current)

            visited[current] = true

            for (i in 0 until adj[current].size)
            {
                val isDone = true
                val child = adj[current][i]
                if (visited[child] == false)
                {
                    visited[child] = true
                    stack.push(child)
                    break
                }

                if (isDone)
                {
                    stack.pop()
                    patharry.add(current)
                    break
                }
            }

        }
        patharry.reverse()
        patharry.forEach { print("-> $it ") }
    }

    dfs(1)

}