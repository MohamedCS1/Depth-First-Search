import java.util.*

fun main() {

    val adj = arrayListOf<LinkedList<Int>>()

    adj.add(LinkedList<Int>())
    adj[0].add(0)

    for (i in 1..6) {
        adj.add(LinkedList<Int>())
    }

    adj[1].add(2)
    adj[2].add(5)
    adj[2].add(4)
    adj[2].add(6)
    adj[3].add(1)
    adj[4].add(3)
    adj[5].add(6)
    adj[5].add(4)
    adj[6].add(4)

    val visited = arrayOfNulls<Boolean>(adj.size +  1)

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
            val top = stack.pop()

            stack.push(top)

            visited[top] = true

            for (i in 0 until adj[top].size)
            {
                val isDone = true
                val child = adj[top][i]
                if (visited[child] == false)
                {
                    visited[child] = true
                    stack.push(child)
                    break
                }

                if (isDone)
                {
                    stack.pop()
                    patharry.add(top)
                    break
                }
            }

        }
        patharry.reverse()
        patharry.forEach { print("-> $it ") }
    }

    dfs(0)

}