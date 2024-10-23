package com.example.codemastery.Questions.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codemastery.Models.QModel
import com.example.codemastery.R
import com.example.codemastery.adapters.QuestionAdapter
import com.example.codemastery.databinding.FragmentQuestionListBinding


class QuestionListFragment : Fragment() {

    private lateinit var binding: FragmentQuestionListBinding
    private lateinit var questionAdapter: QuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater , R.layout.fragment_question_list , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



binding.toolbar4.setNavigationOnClickListener{
    requireActivity().finish()
}
        val subject = arguments?.getString("subtopic")
        if (subject != null) {
            binding.topicName.text = subject
            binding.numberQuestions.text = "20 Qs"
            when (subject) {
                "Arrays" -> getArrayQuestions()
                "Linked Lists" -> getLinkedListQuestions()
                "Trees" -> getTreesQuestions()
                "Stacks" -> getStacksQuestions()
                "Hash Table" -> getHashTableQuestions()
                "Heaps" -> getHeapsQuestions()
                "Trees" -> getTreesQuestions()
                "Graphs" -> getGraphQuestions()
                "Sorting Algorithms" -> getSortingAlgorithmQuestions()
                "Searching Algorithms" -> getSearchingAlgorithmQuestions()
                "Graph Algorithms" -> getGraphAlgorithmQuestions()
                "Dynamic Programming" -> getDynamicProgrammingQuestions()
                "Classes and Objects" -> getClassesAndObjectsQuestions()
                "Inheritance" -> getInheritanceQuestions()
                "Polymorphism" -> getPolymorphismQuestions()
                "Abstraction" -> getAbstractionQuestions()
                "Process Management" -> getProcessManagementQuestions()
                "Concurrency and Synchronisation" -> getConcurrencyAndSynchronizationQuestions()
                "Memory Management" -> getMemoryManagementQuestions()
                "File Systems" -> getFileSystemQuestions()
                "CPU Scheduling Algorithms" -> getCpuSchedulingAlgorithmQuestions()
                "SQL Basics" -> getSqlBasicsQuestions()
                "Normalization" -> getNormalizationQuestions()
                "Indexing" -> getIndexingQuestions()
                "ACID Properties" -> getAcidPropertiesQuestions()
                "NoSQL Databases" -> getNoSqlDatabaseQuestions()
                "Joins" -> getJoinsQuestions()
                "OSI Model" -> getOSIModelQuestions()
                "TCP/IP Model" -> getTcpIpModelQuestions()
                "Routing Algorithms" -> getRoutingAlgorithmQuestions()
                "IP Addressing" -> getIpAddressingQuestions()
                "Network Layers" -> getNetworkLayersQuestions()
                "Discrete Math" -> getDiscreteMathQuestions()
                "Probability" -> getProbabilityQuestions()
                "Number Theory" -> getNumberTheoryQuestions()
                "Graph Theory" -> getNumberTheoryQuestions()
                "Modular Arithematic" -> getModularArithmeticQuestions()
                "Statistics" -> getStatisticsQuestions()
                "Linear Algebra" -> getLinearAlgebraQuestions()
                "Functional Progarmming" -> getFunctionalProgrammingQuestions()
                "Object-Oriented Programming" -> getOopQuestions()
                "Imperative v/s Declarative" -> getImperativeVsDeclarativeQuestions()
                "Event-driven Programming" -> getEventDrivenProgrammingQuestions()
                "Git Basics" -> getGitBasicsQuestions()
                "Branches"-> getBranchesQuestions()
                "Merge Conflicts" -> getMergeConflictQuestions()
                "Rebasing" -> getRebasingQuestions()
                "Encryption" -> getEncryptionQuestions()
                "Authentication" -> getAuthenticationQuestions()
                "Network Security" -> getNetworkSecurityQuestions()
                "Cryptography" -> getCryptographyQuestions()






            }
        }
        handleBackPress()

    }

    private fun getStacksQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a stack?", mutableListOf("A linear data structure that follows LIFO", "A data structure that follows FIFO", "A hierarchical data structure", "None of the above"), 1))
        questionList.add(QModel(2, "Which operation is used to add an element to a stack?", mutableListOf("Push", "Pop", "Enqueue", "Dequeue"), 1))
        questionList.add(QModel(3, "Which operation is used to remove an element from a stack?", mutableListOf("Push", "Pop", "Enqueue", "Dequeue"), 2))
        questionList.add(QModel(4, "What is the time complexity of accessing an element in a stack?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 1))
        questionList.add(QModel(5, "Which of the following is NOT a use of stacks?", mutableListOf("Expression evaluation", "Backtracking", "Memory management", "Graph traversal"), 4))
        questionList.add(QModel(6, "In a stack, which element is removed first?", mutableListOf("First element added", "Last element added", "Middle element", "None of the above"), 2))
        questionList.add(QModel(7, "What is the main advantage of using a stack?", mutableListOf("Allows random access", "Easier to implement than queues", "Maintains order of operations", "None of the above"), 3))
        questionList.add(QModel(8, "What will happen if we pop an element from an empty stack?", mutableListOf("Return null", "Throw an exception", "Return 0", "None of the above"), 2))
        questionList.add(QModel(9, "Which of the following can be implemented using stacks?", mutableListOf("Function call management", "Undo mechanisms in applications", "Expression parsing", "All of the above"), 4))
        questionList.add(QModel(10, "Which data structure is commonly used to implement a stack?", mutableListOf("Array", "Linked List", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(11, "What is the maximum size of a stack defined with an array?", mutableListOf("Dynamic", "Fixed", "Depends on the compiler", "Depends on the algorithm"), 2))
        questionList.add(QModel(12, "Which traversal is suitable for traversing a stack?", mutableListOf("Pre-order", "Post-order", "In-order", "None of the above"), 4))
        questionList.add(QModel(13, "What is a stack overflow?", mutableListOf("Adding an element to a full stack", "Removing an element from an empty stack", "Accessing an element outside the stack range", "None of the above"), 1))
        questionList.add(QModel(14, "What is the main characteristic of a stack?", mutableListOf("Elements are added and removed in random order", "Elements are added and removed in a first-in, first-out manner", "Elements are added and removed in a last-in, first-out manner", "None of the above"), 3))
        questionList.add(QModel(15, "What is a stack underflow?", mutableListOf("Accessing an element in an empty stack", "Popping an element from an empty stack", "Pushing an element to a full stack", "None of the above"), 2))
        questionList.add(QModel(16, "Which of the following is true about stacks?", mutableListOf("They can grow dynamically", "They can only be implemented with linked lists", "They are not limited in size", "They follow FIFO order"), 1))
        questionList.add(QModel(17, "What is the size of an empty stack?", mutableListOf("1", "0", "Depends on the implementation", "Undefined"), 2))
        questionList.add(QModel(18, "Which algorithm uses a stack data structure for its implementation?", mutableListOf("Breadth-first search", "Depth-first search", "Dijkstra's algorithm", "None of the above"), 2))
        questionList.add(QModel(19, "What happens to the stack pointer when an element is pushed onto the stack?", mutableListOf("It moves up", "It moves down", "It remains the same", "It resets to zero"), 1))
        questionList.add(QModel(20, "In what context is a stack particularly useful?", mutableListOf("When the order of processing matters", "When processing needs to happen simultaneously", "When data needs to be sorted", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }


    private fun handleBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
    }


    private fun getTreesQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a binary tree?", mutableListOf("A tree with at most two children", "A tree with multiple children", "A tree with no children", "A special type of linked list"), 1))
        questionList.add(QModel(2, "What is the maximum number of nodes in a binary tree of height h?", mutableListOf("2^h - 1", "h^2", "2h", "h + 1"), 1))
        questionList.add(QModel(3, "What traversal method visits the root node first in a binary tree?", mutableListOf("In-order", "Pre-order", "Post-order", "Level-order"), 2))
        questionList.add(QModel(4, "In a binary search tree, which node is greater than the root?", mutableListOf("Left child", "Right child", "Both children", "None of the above"), 2))
        questionList.add(QModel(5, "What is the time complexity of searching for an element in a balanced binary search tree?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 2))
        questionList.add(QModel(6, "Which of the following is NOT a type of binary tree?", mutableListOf("Full binary tree", "Complete binary tree", "Perfect binary tree", "Simple binary tree"), 4))
        questionList.add(QModel(7, "What is the main characteristic of a self-balancing binary search tree?", mutableListOf("Nodes are always in a sorted order", "It maintains a balanced height", "Nodes can have multiple children", "None of the above"), 2))
        questionList.add(QModel(8, "What is the height of a complete binary tree with n nodes?", mutableListOf("log(n)", "n", "n - 1", "n/2"), 1))
        questionList.add(QModel(9, "What is a leaf node in a tree?", mutableListOf("A node with one child", "A node with no children", "A node with two children", "A node at the highest level"), 2))
        questionList.add(QModel(10, "In which traversal method are nodes visited in the order of left, root, right?", mutableListOf("Pre-order", "In-order", "Post-order", "Level-order"), 2))
        questionList.add(QModel(11, "Which data structure can be used to implement a binary tree?", mutableListOf("Array", "Linked List", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(12, "What is the main disadvantage of using a linked representation for binary trees?", mutableListOf("Higher memory usage", "Slower traversal", "More complex implementation", "None of the above"), 1))
        questionList.add(QModel(13, "Which algorithm is commonly used to find the shortest path in a weighted tree?", mutableListOf("Dijkstra's algorithm", "Kruskal's algorithm", "Prim's algorithm", "A* algorithm"), 1))
        questionList.add(QModel(14, "In a binary tree, what is the degree of a leaf node?", mutableListOf("0", "1", "2", "Variable"), 1))
        questionList.add(QModel(15, "What is the total number of leaf nodes in a full binary tree with h height?", mutableListOf("h", "2^h", "2^(h+1)", "2^(h-1)"), 2))
        questionList.add(QModel(16, "What is the depth of a node in a tree?", mutableListOf("The number of edges from the root to the node", "The total number of nodes from root to the leaf", "The number of children of a node", "None of the above"), 1))
        questionList.add(QModel(17, "What traversal method is used for depth-first search?", mutableListOf("In-order", "Pre-order", "Post-order", "All of the above"), 4))
        questionList.add(QModel(18, "Which of the following trees can store data in a sorted manner?", mutableListOf("Binary tree", "Binary search tree", "AVL tree", "Both B and C"), 4))
        questionList.add(QModel(19, "What is the common use of a binary tree?", mutableListOf("Expression evaluation", "Hierarchical data representation", "Searching", "All of the above"), 4))
        questionList.add(QModel(20, "What is the worst-case time complexity for deleting a node from a binary search tree?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 3))

        setUpRecyclerView(questionList)
    }


    private fun getLinkedListQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a linked list?", mutableListOf("A collection of nodes", "An array", "A stack", "A queue"), 1))
        questionList.add(QModel(2, "What is the primary advantage of a linked list over an array?", mutableListOf("Dynamic size", "Faster access", "Better memory locality", "Easier sorting"), 1))
        questionList.add(QModel(3, "Which pointer is used to link the nodes in a doubly linked list?", mutableListOf("Next pointer", "Previous pointer", "Both next and previous", "None of the above"), 3))
        questionList.add(QModel(4, "What is the time complexity for adding an element to the front of a linked list?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n^2)"), 1))
        questionList.add(QModel(5, "What is the main disadvantage of linked lists?", mutableListOf("Memory overhead", "Dynamic size", "Ease of insertion", "Ease of deletion"), 1))
        questionList.add(QModel(6, "In a circular linked list, which node points back to the head?", mutableListOf("Tail node", "Head node", "Middle node", "None of the above"), 1))
        questionList.add(QModel(7, "What is the purpose of a sentinel node in a linked list?", mutableListOf("To simplify operations", "To store data", "To make traversal faster", "To save memory"), 1))
        questionList.add(QModel(8, "What is the time complexity for searching an element in a linked list?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 2))
        questionList.add(QModel(9, "What is a common application of a linked list?", mutableListOf("Implementing stacks", "Implementing queues", "Dynamic memory allocation", "All of the above"), 4))
        questionList.add(QModel(10, "How do you find the middle element of a linked list?", mutableListOf("Two-pointer technique", "Counting nodes", "Recursive approach", "Binary search"), 1))
        questionList.add(QModel(11, "What will happen if you try to access a null node in a linked list?", mutableListOf("Program crash", "Segmentation fault", "Return null", "No effect"), 1))
        questionList.add(QModel(12, "What is the memory overhead of a linked list compared to an array?", mutableListOf("Lower", "Higher", "Same", "Depends on implementation"), 2))
        questionList.add(QModel(13, "Which type of linked list allows traversal in both directions?", mutableListOf("Singly linked list", "Doubly linked list", "Circular linked list", "All of the above"), 2))
        questionList.add(QModel(14, "What is the worst-case time complexity for deleting a node from a linked list?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n^2)"), 2))
        questionList.add(QModel(15, "Which of the following operations is NOT efficient in a linked list?", mutableListOf("Insertion at the head", "Insertion at the tail", "Accessing an element by index", "Deletion of a node"), 3))
        questionList.add(QModel(16, "What is the purpose of the head pointer in a linked list?", mutableListOf("To point to the first node", "To point to the last node", "To point to the middle node", "To store the size"), 1))
        questionList.add(QModel(17, "What data structure can be used to implement recursion?", mutableListOf("Queue", "Array", "Stack", "Linked List"), 3))
        questionList.add(QModel(18, "How can you reverse a linked list?", mutableListOf("Iterative method", "Recursive method", "Using a stack", "All of the above"), 4))
        questionList.add(QModel(19, "What happens when the linked list becomes circular?", mutableListOf("Infinite loop during traversal", "Memory overflow", "Crash", "No effect"), 1))
        questionList.add(QModel(20, "Which algorithm is best suited for merging two sorted linked lists?", mutableListOf("Merge sort", "Quick sort", "Insertion sort", "Two-pointer technique"), 4))

        setUpRecyclerView(questionList)
    }


    private fun setUpRecyclerView(questionList: List<QModel>) {
        questionAdapter = QuestionAdapter(questionList)
        binding.questionList.apply {
            adapter = questionAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getArrayQuestions() {
        val questionList = mutableListOf<QModel>()

            questionList.add(QModel(1, "What is the time complexity of accessing an element in an array?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n^2)"), 1))
            questionList.add(QModel(2, "Which of the following is a characteristic of a dynamic array?", mutableListOf("Fixed size", "Random access", "Low memory overhead", "All of the above"), 2))
            questionList.add(QModel(3, "In which scenario would you prefer a linked list over an array?", mutableListOf("When you need random access", "When memory overhead is a concern", "When frequent insertions and deletions are required", "When you need a fixed-size structure"), 3))
            questionList.add(QModel(4, "What happens if an array is accessed out of its bounds in Java?", mutableListOf("Returns null", "Throws an ArrayIndexOutOfBoundsException", "Returns 0", "No effect"), 2))
            questionList.add(QModel(5, "Which of the following operations is more efficient in a linked list than in an array?", mutableListOf("Accessing an element", "Inserting an element", "Iterating through elements", "None of the above"), 2))
            questionList.add(QModel(6, "What is the worst-case time complexity for searching an element in a sorted array using binary search?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 2))
            questionList.add(QModel(7, "Which data structure allows for constant time insertions and deletions?", mutableListOf("Array", "Stack", "Queue", "Linked List"), 4))
            questionList.add(QModel(8, "In an array of integers, what is the maximum number of comparisons needed to find the minimum value using a linear search?", mutableListOf("n", "n/2", "log n", "n - 1"), 4))
            questionList.add(QModel(9, "Which of the following can be used to implement a queue?", mutableListOf("Array", "Linked List", "Both A and B", "None of the above"), 3))
            questionList.add(QModel(10, "What is the average-case time complexity for inserting an element into a hash table?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 1))
            questionList.add(QModel(11, "Which of the following is NOT a benefit of using an array?", mutableListOf("Random access", "Ease of iteration", "Dynamic resizing", "Memory efficiency"), 3))
            questionList.add(QModel(12, "In a circular linked list, what is the main challenge in implementation?", mutableListOf("Memory management", "End of the list detection", "Random access", "Data duplication"), 2))
            questionList.add(QModel(13, "Which of the following is a characteristic of a stack?", mutableListOf("FIFO", "LIFO", "Dynamic resizing", "Random access"), 2))
            questionList.add(QModel(14, "What is the average time complexity for deleting an element from a binary search tree?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 2))
            questionList.add(QModel(15, "What is the space complexity of an array with n elements?", mutableListOf("O(1)", "O(n)", "O(n^2)", "O(log n)"), 2))
            questionList.add(QModel(16, "What is the primary disadvantage of using an array?", mutableListOf("Memory inefficiency", "Fixed size", "Complexity of implementation", "Random access"), 2))
            questionList.add(QModel(17, "What data structure uses a Last In First Out (LIFO) principle?", mutableListOf("Queue", "Array", "Stack", "Tree"), 3))
            questionList.add(QModel(18, "What is the space complexity of a linked list with n elements?", mutableListOf("O(1)", "O(n)", "O(n^2)", "O(log n)"), 2))
            questionList.add(QModel(19, "What will be the output of accessing an element at an index greater than the array size in C++?", mutableListOf("Undefined behavior", "Exception", "Zero", "Null"), 1))
            questionList.add(QModel(20, "What is a disadvantage of using a linked list compared to an array?", mutableListOf("Memory overhead", "Random access", "Simplicity", "None of the above"), 1))
            questionList.add(QModel(21, "In which data structure is a breadth-first search implemented?", mutableListOf("Stack", "Queue", "Array", "Linked List"), 2))
            questionList.add(QModel(22, "What type of data structure is used to implement recursion?", mutableListOf("Queue", "Stack", "Array", "Linked List"), 2))
            questionList.add(QModel(23, "Which algorithm can be used to sort an array in O(n log n) time complexity?", mutableListOf("Bubble sort", "Quick sort", "Selection sort", "Insertion sort"), 2))
            questionList.add(QModel(24, "Which of the following can cause a stack overflow?", mutableListOf("Queue", "Recursion", "Array", "Linked List"), 2))
            questionList.add(QModel(25, "What is the best case time complexity of bubble sort?", mutableListOf("O(n)", "O(n^2)", "O(log n)", "O(n log n)"), 1))
            questionList.add(QModel(26, "Which sorting algorithm is not based on comparison?", mutableListOf("Quick sort", "Merge sort", "Radix sort", "Heap sort"), 3))
            questionList.add(QModel(27, "What is the time complexity of inserting an element at the beginning of an array?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n^2)"), 2))
            questionList.add(QModel(28, "How many comparisons are needed to sort an array of n elements using selection sort?", mutableListOf("O(n)", "O(n log n)", "O(n^2)", "O(log n)"), 3))
            questionList.add(QModel(29, "Which of the following methods can be used to reverse an array?", mutableListOf("Two-pointer technique", "Recursion", "Iterative swapping", "All of the above"), 4))
            questionList.add(QModel(30, "What is the time complexity to merge two sorted arrays of sizes m and n?", mutableListOf("O(m+n)", "O(m*n)", "O(log(m+n))", "O(m-n)"), 1))
            questionList.add(QModel(31, "In an array, how can we find the second largest element?", mutableListOf("Sort the array", "Linear search", "Binary search", "Both A and B"), 4))
            questionList.add(QModel(32, "What is the space complexity of a dynamic array?", mutableListOf("O(1)", "O(n)", "O(n^2)", "O(log n)"), 2))
            questionList.add(QModel(33, "How do you detect a cycle in an array?", mutableListOf("Using a hash table", "Floyd’s Cycle Detection", "Sorting", "Both A and B"), 4))
            questionList.add(QModel(34, "Which algorithm is used for rotating an array?", mutableListOf("Merge sort", "Reverse algorithm", "Insertion sort", "Selection sort"), 2))
            questionList.add(QModel(35, "What is the time complexity of finding the intersection of two arrays?", mutableListOf("O(n)", "O(m+n)", "O(n log n)", "O(m log n)"), 2))
            questionList.add(QModel(36, "Which of the following is true about arrays?", mutableListOf("They can store elements of different data types", "They have a fixed size", "They have high memory overhead", "All of the above"), 2))
            questionList.add(QModel(37, "In a sorted array, which algorithm is best for finding an element?", mutableListOf("Linear search", "Binary search", "Jump search", "Interpolation search"), 2))
            questionList.add(QModel(38, "What will be the output of the following code? int arr[5] = {1, 2, 3}; cout << arr[3];", mutableListOf("0", "Undefined behavior", "Segmentation fault", "Runtime error"), 1))
            questionList.add(QModel(39, "Which data structure is more space-efficient for storing large datasets?", mutableListOf("Array", "Linked List", "Hash Table", "Binary Tree"), 2))
            questionList.add(QModel(40, "What is the time complexity for deleting an element from a dynamic array?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 2))
            questionList.add(QModel(41, "Which of the following is not a valid operation for arrays?", mutableListOf("Insertion", "Deletion", "Traversal", "Merge without copying"), 4))



        setUpRecyclerView(questionList)
    }

    private fun getHashTableQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a hash table?", mutableListOf("A data structure that stores key-value pairs", "A linear data structure", "A tree-based data structure", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is used to handle collisions in a hash table?", mutableListOf("Chaining", "Open addressing", "Double hashing", "All of the above"), 4))
        questionList.add(QModel(3, "What is the average time complexity for search operations in a hash table?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 1))
        questionList.add(QModel(4, "What happens when two keys hash to the same index in a hash table?", mutableListOf("The first key is replaced by the second", "A collision occurs", "Both keys are stored at that index", "None of the above"), 2))
        questionList.add(QModel(5, "Which of the following is NOT a characteristic of a hash table?", mutableListOf("Dynamic resizing", "Random access", "Ordered storage", "Collision resolution"), 3))
        questionList.add(QModel(6, "What is a hash function?", mutableListOf("A function that encrypts data", "A function that maps keys to indices", "A function that sorts data", "None of the above"), 2))
        questionList.add(QModel(7, "Which data structure can be implemented using a hash table?", mutableListOf("Sets", "Maps", "Caches", "All of the above"), 4))
        questionList.add(QModel(8, "What is the load factor in a hash table?", mutableListOf("The ratio of stored elements to the size of the table", "The maximum number of collisions allowed", "The time taken to insert an element", "None of the above"), 1))
        questionList.add(QModel(9, "In a hash table, what is the purpose of resizing?", mutableListOf("To reduce the load factor", "To increase the size of the hash function", "To improve search time", "None of the above"), 1))
        questionList.add(QModel(10, "Which of the following is a disadvantage of hash tables?", mutableListOf("Fast access times", "Requires additional memory for collision resolution", "Ordering of elements", "All of the above"), 3))
        questionList.add(QModel(11, "What is the primary disadvantage of using a hash table?", mutableListOf("It requires more memory than an array", "It has slower access times than arrays", "It does not allow duplicate keys", "None of the above"), 1))
        questionList.add(QModel(12, "Which collision resolution method uses linked lists?", mutableListOf("Open addressing", "Chaining", "Double hashing", "None of the above"), 2))
        questionList.add(QModel(13, "What is a perfect hash function?", mutableListOf("A hash function that minimizes collisions", "A hash function that uses only integer keys", "A hash function that is always linear", "None of the above"), 1))
        questionList.add(QModel(14, "What does it mean for a hash table to be 'open-addressed'?", mutableListOf("All entries are stored in a single array", "Collisions are resolved by probing for the next open slot", "A linked list is used for collision resolution", "None of the above"), 2))
        questionList.add(QModel(15, "What is a potential issue with using a poorly designed hash function?", mutableListOf("Increased performance", "Higher collision rates", "Lower memory usage", "All of the above"), 2))
        questionList.add(QModel(16, "What kind of operations can be performed on a hash table?", mutableListOf("Insertion", "Deletion", "Search", "All of the above"), 4))
        questionList.add(QModel(17, "In which scenario would you prefer a hash table over an array?", mutableListOf("When order matters", "When fast lookups are required", "When memory usage is a priority", "All of the above"), 2))
        questionList.add(QModel(18, "How is a hash table generally implemented?", mutableListOf("With a binary tree", "With an array", "With a linked list", "None of the above"), 2))
        questionList.add(QModel(19, "What is the worst-case time complexity for search operations in a hash table?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 2))
        questionList.add(QModel(20, "When is it appropriate to use a hash table?", mutableListOf("When you need to maintain the order of elements", "When you need fast access by key", "When you are working with large data sets", "None of the above"), 2))

        setUpRecyclerView(questionList)
    }

    private fun getHeapsQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a heap?", mutableListOf("A complete binary tree", "A partially ordered tree", "A data structure that supports priority queues", "All of the above"), 4))
        questionList.add(QModel(2, "In a max heap, which property is maintained?", mutableListOf("Parent nodes are greater than or equal to their children", "Parent nodes are less than or equal to their children", "All nodes are equal", "None of the above"), 1))
        questionList.add(QModel(3, "What is the time complexity of inserting an element in a heap?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 2))
        questionList.add(QModel(4, "Which of the following is a common application of heaps?", mutableListOf("Sorting algorithms", "Priority queues", "Graph algorithms", "All of the above"), 4))
        questionList.add(QModel(5, "What is the time complexity of removing the root element from a heap?", mutableListOf("O(1)", "O(log n)", "O(n)", "O(n log n)"), 2))
        questionList.add(QModel(6, "In a min heap, which property is maintained?", mutableListOf("Parent nodes are greater than or equal to their children", "Parent nodes are less than or equal to their children", "All nodes are equal", "None of the above"), 2))
        questionList.add(QModel(7, "Which of the following heaps allows for faster access to the minimum element?", mutableListOf("Max heap", "Min heap", "Binary tree", "AVL tree"), 2))
        questionList.add(QModel(8, "What is the maximum number of nodes in a binary heap of height h?", mutableListOf("2^h - 1", "2^(h+1) - 1", "h^2", "n"), 2))
        questionList.add(QModel(9, "What is a binary heap?", mutableListOf("A tree that satisfies the heap property", "A tree that is complete", "A tree that is balanced", "Both A and B"), 4))
        questionList.add(QModel(10, "How is a heap typically implemented?", mutableListOf("Using an array", "Using a linked list", "Using a binary tree", "Using a hash table"), 1))
        questionList.add(QModel(11, "What is the space complexity of a heap?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 2))
        questionList.add(QModel(12, "What type of traversal is used to build a heap from an array?", mutableListOf("Pre-order", "In-order", "Post-order", "Heapify"), 4))
        questionList.add(QModel(13, "Which operation is NOT typically associated with heaps?", mutableListOf("Insert", "Delete", "Search", "Extract min/max"), 3))
        questionList.add(QModel(14, "Which algorithm is commonly used to convert an array into a heap?", mutableListOf("Quick Sort", "Heap Sort", "Merge Sort", "Bubble Sort"), 2))
        questionList.add(QModel(15, "What is the worst-case time complexity for building a heap from an array of n elements?", mutableListOf("O(n log n)", "O(n)", "O(log n)", "O(n^2)"), 2))
        questionList.add(QModel(16, "What is a binary max heap?", mutableListOf("A complete binary tree where each parent is greater than its children", "A complete binary tree where each parent is less than its children", "A balanced tree", "None of the above"), 1))
        questionList.add(QModel(17, "What is the primary use of heaps in computer science?", mutableListOf("To sort data", "To store data in a key-value format", "To implement priority queues", "All of the above"), 4))
        questionList.add(QModel(18, "Which data structure is commonly used to implement a priority queue?", mutableListOf("Array", "Linked List", "Heap", "Hash Table"), 3))
        questionList.add(QModel(19, "What happens when you delete the root of a heap?", mutableListOf("The last element replaces it", "The tree is rebalanced", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(20, "What is the main advantage of using a heap over a regular binary tree?", mutableListOf("Faster access to the minimum/maximum", "Less memory usage", "Easier implementation", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }

    private fun getGraphQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a graph?", mutableListOf("A collection of nodes and edges", "A linear data structure", "A hierarchical data structure", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following represents a weighted graph?", mutableListOf("Graph with no edges", "Graph with edges having weights", "Graph with only one vertex", "None of the above"), 2))
        questionList.add(QModel(3, "What is the time complexity of BFS in a graph?", mutableListOf("O(V + E)", "O(V^2)", "O(E^2)", "O(V log V)"), 1))
        questionList.add(QModel(4, "Which of the following algorithms is used for finding the shortest path in a graph?", mutableListOf("Dijkstra's algorithm", "Depth-first search", "Bubble sort", "Prim's algorithm"), 1))
        questionList.add(QModel(5, "What is a directed graph?", mutableListOf("Graph with no edges", "Graph where edges have a direction", "Graph with only one vertex", "None of the above"), 2))
        questionList.add(QModel(6, "In graph terminology, what is a vertex?", mutableListOf("An edge connecting two nodes", "A single point in a graph", "A cycle in a graph", "None of the above"), 2))
        questionList.add(QModel(7, "Which traversal method visits all nodes of a graph?", mutableListOf("Depth-first search", "Breadth-first search", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(8, "What is the main difference between BFS and DFS?", mutableListOf("BFS uses a queue, while DFS uses a stack", "BFS is faster than DFS", "DFS is more memory-efficient than BFS", "None of the above"), 1))
        questionList.add(QModel(9, "What is a complete graph?", mutableListOf("A graph where every vertex is connected to every other vertex", "A graph with no edges", "A graph with only one vertex", "None of the above"), 1))
        questionList.add(QModel(10, "What is the degree of a vertex?", mutableListOf("The number of edges connected to it", "The distance to the farthest vertex", "The total weight of edges connected to it", "None of the above"), 1))
        questionList.add(QModel(11, "What is a cycle in a graph?", mutableListOf("A path that visits each vertex exactly once", "A path that starts and ends at the same vertex", "A disconnected part of the graph", "None of the above"), 2))
        questionList.add(QModel(12, "Which of the following is NOT a representation of a graph?", mutableListOf("Adjacency matrix", "Adjacency list", "Edge list", "Tree list"), 4))
        questionList.add(QModel(13, "What is a bipartite graph?", mutableListOf("A graph with two sets of vertices", "A graph with weighted edges", "A graph with no cycles", "None of the above"), 1))
        questionList.add(QModel(14, "What does it mean for a graph to be connected?", mutableListOf("All vertices are reachable from any vertex", "There are no edges", "It has a cycle", "None of the above"), 1))
        questionList.add(QModel(15, "What is the purpose of Kruskal's algorithm?", mutableListOf("To find the shortest path", "To find the minimum spanning tree", "To check for cycles", "None of the above"), 2))
        questionList.add(QModel(16, "What is an acyclic graph?", mutableListOf("A graph with cycles", "A graph without cycles", "A graph that is not connected", "None of the above"), 2))
        questionList.add(QModel(17, "What is a spanning tree?", mutableListOf("A tree that covers all vertices of a graph", "A tree with a maximum number of edges", "A tree with cycles", "None of the above"), 1))
        questionList.add(QModel(18, "Which algorithm is used to find a minimum spanning tree?", mutableListOf("Dijkstra's algorithm", "Kruskal's algorithm", "A* algorithm", "Prim's algorithm"), 2))
        questionList.add(QModel(19, "What is the main advantage of using an adjacency list over an adjacency matrix?", mutableListOf("Less memory usage for sparse graphs", "Faster access times", "Easier to implement", "None of the above"), 1))
        questionList.add(QModel(20, "What is a topological sort?", mutableListOf("A linear ordering of vertices in a directed graph", "A way to find cycles in a graph", "A method for traversing all edges", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getSortingAlgorithmQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a sorting algorithm?", mutableListOf("An algorithm to arrange data in a specific order", "An algorithm to search data", "An algorithm to compress data", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a comparison-based sorting algorithm?", mutableListOf("Bubble Sort", "Counting Sort", "Radix Sort", "Bucket Sort"), 1))
        questionList.add(QModel(3, "What is the time complexity of Quick Sort in the average case?", mutableListOf("O(n log n)", "O(n^2)", "O(log n)", "O(n)"), 1))
        questionList.add(QModel(4, "Which sorting algorithm is known for its divide-and-conquer approach?", mutableListOf("Bubble Sort", "Insertion Sort", "Merge Sort", "Selection Sort"), 3))
        questionList.add(QModel(5, "What is the worst-case time complexity of Bubble Sort?", mutableListOf("O(n log n)", "O(n^2)", "O(n)", "O(log n)"), 2))
        questionList.add(QModel(6, "Which sorting algorithm is stable?", mutableListOf("Quick Sort", "Heap Sort", "Merge Sort", "Selection Sort"), 3))
        questionList.add(QModel(7, "What is the space complexity of Merge Sort?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n log n)"), 2))
        questionList.add(QModel(8, "Which of the following algorithms is not an in-place sorting algorithm?", mutableListOf("Insertion Sort", "Selection Sort", "Merge Sort", "Heap Sort"), 3))
        questionList.add(QModel(9, "What is the primary characteristic of Selection Sort?", mutableListOf("Divides the list into two parts", "Repeatedly selects the minimum element", "Uses recursion", "None of the above"), 2))
        questionList.add(QModel(10, "What is the best-case time complexity of Insertion Sort?", mutableListOf("O(n)", "O(n log n)", "O(n^2)", "O(log n)"), 1))
        questionList.add(QModel(11, "Which sorting algorithm is based on partitioning the array?", mutableListOf("Insertion Sort", "Bubble Sort", "Quick Sort", "Selection Sort"), 3))
        questionList.add(QModel(12, "Which sorting algorithm uses a heap data structure?", mutableListOf("Bubble Sort", "Heap Sort", "Insertion Sort", "Merge Sort"), 2))
        questionList.add(QModel(13, "What is the time complexity of Counting Sort?", mutableListOf("O(n + k)", "O(n log n)", "O(n^2)", "O(k log k)"), 1))
        questionList.add(QModel(14, "What is the main advantage of Radix Sort?", mutableListOf("It is a comparison sort", "It can sort large numbers efficiently", "It is stable", "It is in-place"), 2))
        questionList.add(QModel(15, "Which of the following sorting algorithms is not efficient for large datasets?", mutableListOf("Merge Sort", "Quick Sort", "Bubble Sort", "Heap Sort"), 3))
        questionList.add(QModel(16, "What is the primary disadvantage of Quick Sort?", mutableListOf("It is not stable", "It is recursive", "It requires additional space", "It is not in-place"), 1))
        questionList.add(QModel(17, "Which algorithm is typically used for external sorting?", mutableListOf("Quick Sort", "Merge Sort", "Heap Sort", "Bubble Sort"), 2))
        questionList.add(QModel(18, "What is a characteristic of Heap Sort?", mutableListOf("It is stable", "It is in-place", "It uses divide and conquer", "It is recursive"), 2))
        questionList.add(QModel(19, "What type of sort is Shell Sort?", mutableListOf("Comparison-based", "Non-comparison-based", "Stable", "In-place"), 1))
        questionList.add(QModel(20, "Which of the following algorithms is commonly used to sort linked lists?", mutableListOf("Quick Sort", "Heap Sort", "Merge Sort", "Bubble Sort"), 3))

        setUpRecyclerView(questionList)
    }
    private fun getSearchingAlgorithmQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a searching algorithm?", mutableListOf("A method for finding a specific value in a data structure", "A method for sorting data", "A method for storing data", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a linear search algorithm?", mutableListOf("Binary search", "Jump search", "Exponential search", "Sequential search"), 4))
        questionList.add(QModel(3, "What is the time complexity of a binary search?", mutableListOf("O(n)", "O(log n)", "O(n log n)", "O(1)"), 2))
        questionList.add(QModel(4, "Which condition must be true for binary search to work?", mutableListOf("The array must be unsorted", "The array must be sorted", "The array must contain duplicates", "None of the above"), 2))
        questionList.add(QModel(5, "What is a hash table?", mutableListOf("A data structure that uses key-value pairs", "A method for sorting data", "A type of tree structure", "None of the above"), 1))
        questionList.add(QModel(6, "Which algorithm is faster for searching in a sorted array?", mutableListOf("Linear search", "Binary search", "Interpolation search", "Depth-first search"), 2))
        questionList.add(QModel(7, "What is interpolation search?", mutableListOf("A search algorithm that estimates where the value is likely to be", "A search algorithm that checks each element sequentially", "A search algorithm that uses a hash table", "None of the above"), 1))
        questionList.add(QModel(8, "Which of the following search algorithms has the best average-case time complexity?", mutableListOf("Linear search", "Binary search", "Jump search", "Ternary search"), 2))
        questionList.add(QModel(9, "What is the worst-case time complexity of linear search?", mutableListOf("O(1)", "O(n)", "O(log n)", "O(n^2)"), 2))
        questionList.add(QModel(10, "What type of search is used in databases?", mutableListOf("Depth-first search", "Breadth-first search", "Binary search", "Indexing"), 4))
        questionList.add(QModel(11, "What is a sentinel in searching algorithms?", mutableListOf("A value that marks the end of a list", "A value that is used for optimization", "A type of search tree", "None of the above"), 2))
        questionList.add(QModel(12, "Which searching algorithm is commonly used in a binary tree?", mutableListOf("Depth-first search", "Breadth-first search", "Binary search", "Both A and B"), 4))
        questionList.add(QModel(13, "What is the primary drawback of linear search?", mutableListOf("It requires sorted data", "It has a high time complexity", "It is difficult to implement", "None of the above"), 2))
        questionList.add(QModel(14, "What is the main advantage of using binary search over linear search?", mutableListOf("It works with unsorted data", "It has a lower time complexity", "It is easier to implement", "None of the above"), 2))
        questionList.add(QModel(15, "In which data structure is the binary search algorithm most commonly used?", mutableListOf("Linked list", "Array", "Hash table", "Graph"), 2))
        questionList.add(QModel(16, "What is a tree search algorithm?", mutableListOf("An algorithm that searches in a linear data structure", "An algorithm that searches in a tree data structure", "An algorithm that searches in a graph", "None of the above"), 2))
        questionList.add(QModel(17, "What does the term 'search space' refer to?", mutableListOf("The area in which the search is conducted", "The data structure being searched", "The total number of items to be searched", "None of the above"), 3))
        questionList.add(QModel(18, "What is the significance of the divide-and-conquer technique in searching algorithms?", mutableListOf("It breaks the problem into smaller subproblems", "It combines data structures", "It minimizes memory usage", "None of the above"), 1))
        questionList.add(QModel(19, "What is the primary purpose of search algorithms?", mutableListOf("To find specific data", "To sort data", "To store data", "None of the above"), 1))
        questionList.add(QModel(20, "What is the primary difference between depth-first search and breadth-first search?", mutableListOf("DFS explores as far as possible along each branch before backtracking, while BFS explores all neighbors at the present depth before moving on", "DFS is more efficient than BFS", "BFS can only be used on trees", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getGraphAlgorithmQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a graph?", mutableListOf("A collection of nodes and edges", "A collection of arrays", "A collection of lists", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following algorithms is used for finding the shortest path in a graph?", mutableListOf("Depth-First Search", "Dijkstra's Algorithm", "Kruskal's Algorithm", "Breadth-First Search"), 2))
        questionList.add(QModel(3, "What is the time complexity of Depth-First Search (DFS) on a graph with V vertices and E edges?", mutableListOf("O(V + E)", "O(V^2)", "O(E)", "O(V log V)"), 1))
        questionList.add(QModel(4, "Which data structure is commonly used to implement a graph?", mutableListOf("Array", "Linked List", "Adjacency Matrix", "All of the above"), 4))
        questionList.add(QModel(5, "What is the main difference between directed and undirected graphs?", mutableListOf("Directed graphs have edges with direction", "Undirected graphs have edges with direction", "Both are the same", "None of the above"), 1))
        questionList.add(QModel(6, "What algorithm is used to find a minimum spanning tree?", mutableListOf("Dijkstra's Algorithm", "Prim's Algorithm", "Bellman-Ford Algorithm", "Depth-First Search"), 2))
        questionList.add(QModel(7, "Which of the following is NOT a property of a tree?", mutableListOf("It is a connected graph", "It has cycles", "It has no cycles", "It has one root node"), 2))
        questionList.add(QModel(8, "In which algorithm do you use a priority queue to determine the next node to process?", mutableListOf("Prim's Algorithm", "Kruskal's Algorithm", "Dijkstra's Algorithm", "Both A and C"), 4))
        questionList.add(QModel(9, "What is the time complexity of Kruskal's algorithm?", mutableListOf("O(V + E log V)", "O(E log E)", "O(E + V log V)", "O(V^2)"), 1))
        questionList.add(QModel(10, "Which algorithm is suitable for finding strongly connected components in a directed graph?", mutableListOf("Kruskal's Algorithm", "Dijkstra's Algorithm", "Tarjan's Algorithm", "Prim's Algorithm"), 3))
        questionList.add(QModel(11, "What does a topological sort of a directed acyclic graph (DAG) provide?", mutableListOf("An ordering of vertices", "A cycle detection", "A minimum spanning tree", "A shortest path"), 1))
        questionList.add(QModel(12, "What is the time complexity of the Bellman-Ford algorithm?", mutableListOf("O(V^2)", "O(V + E)", "O(VE)", "O(E log V)"), 3))
        questionList.add(QModel(13, "Which search algorithm can be used to find a path in a maze?", mutableListOf("Depth-First Search", "Dijkstra's Algorithm", "Breadth-First Search", "All of the above"), 4))
        questionList.add(QModel(14, "What is a weighted graph?", mutableListOf("A graph where edges have weights", "A graph where all edges have equal weight", "A graph with only vertices", "None of the above"), 1))
        questionList.add(QModel(15, "Which algorithm is more efficient for sparse graphs?", mutableListOf("Adjacency Matrix", "Adjacency List", "Both are equally efficient", "None of the above"), 2))
        questionList.add(QModel(16, "What is a bipartite graph?", mutableListOf("A graph with two sets of vertices", "A graph with cycles", "A graph with only one vertex", "A graph with all edges connected"), 1))
        questionList.add(QModel(17, "In a graph, what is a leaf node?", mutableListOf("A node with no children", "A node with one child", "A node with two children", "A node with the highest degree"), 1))
        questionList.add(QModel(18, "What does the degree of a vertex represent?", mutableListOf("The number of edges connected to it", "The number of vertices it can reach", "The distance to the farthest vertex", "None of the above"), 1))
        questionList.add(QModel(19, "Which of the following problems can be solved using graph algorithms?", mutableListOf("Finding shortest paths", "Network flow problems", "Traveling salesman problem", "All of the above"), 4))
        questionList.add(QModel(20, "What is the primary use of the Floyd-Warshall algorithm?", mutableListOf("Finding shortest paths between all pairs of vertices", "Finding minimum spanning trees", "Cycle detection", "Pathfinding"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getDynamicProgrammingQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is dynamic programming?", mutableListOf("A method for solving problems by breaking them down into simpler subproblems", "A way of optimizing algorithms by storing intermediate results", "A technique used in recursive algorithms", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following problems can be solved using dynamic programming?", mutableListOf("Fibonacci series", "Knapsack problem", "Longest common subsequence", "All of the above"), 4))
        questionList.add(QModel(3, "What is memoization?", mutableListOf("Storing the results of expensive function calls", "A technique for reducing space complexity", "A way to optimize sorting algorithms", "None of the above"), 1))
        questionList.add(QModel(4, "What is the main advantage of dynamic programming?", mutableListOf("Reduces time complexity by avoiding redundant calculations", "Uses less memory", "Simplifies code", "None of the above"), 1))
        questionList.add(QModel(5, "Which of the following is a characteristic of dynamic programming?", mutableListOf("Optimal substructure", "Overlapping subproblems", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(6, "In the context of dynamic programming, what is a state?", mutableListOf("A specific point in the recursive call tree", "The result of a subproblem", "A unique identifier for each subproblem", "None of the above"), 1))
        questionList.add(QModel(7, "What is the time complexity of solving the Fibonacci sequence using dynamic programming?", mutableListOf("O(n)", "O(n^2)", "O(log n)", "O(2^n)"), 1))
        questionList.add(QModel(8, "Which technique is often used to implement dynamic programming solutions?", mutableListOf("Top-down approach", "Bottom-up approach", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(9, "What is the 'Knapsack problem'?", mutableListOf("A problem that deals with packing items into a container", "A problem that finds the shortest path in a graph", "A problem related to sorting algorithms", "None of the above"), 1))
        questionList.add(QModel(10, "In dynamic programming, what does 'table filling' refer to?", mutableListOf("Storing results of subproblems in a table for reuse", "The process of sorting data", "Filling out a decision tree", "None of the above"), 1))
        questionList.add(QModel(11, "Which of the following is an example of a problem that can be solved with dynamic programming?", mutableListOf("Finding the maximum sum of non-adjacent elements", "Finding the shortest path in an unweighted graph", "Sorting an array", "None of the above"), 1))
        questionList.add(QModel(12, "What is the purpose of a recurrence relation in dynamic programming?", mutableListOf("To define the relationship between subproblems", "To optimize sorting", "To create a function", "None of the above"), 1))
        questionList.add(QModel(13, "What is the time complexity of the 0/1 Knapsack problem using dynamic programming?", mutableListOf("O(n)", "O(n * W)", "O(W)", "O(n^2)"), 2))
        questionList.add(QModel(14, "What does 'optimal substructure' mean in dynamic programming?", mutableListOf("An optimal solution can be constructed from optimal solutions of its subproblems", "Subproblems are independent of each other", "All problems can be reduced to a single subproblem", "None of the above"), 1))
        questionList.add(QModel(15, "What type of problems can be solved using a dynamic programming approach?", mutableListOf("Problems with overlapping subproblems", "Problems with optimal substructure", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(16, "Which of the following is NOT a characteristic of dynamic programming?", mutableListOf("Optimal substructure", "Greedy choice property", "Overlapping subproblems", "None of the above"), 2))
        questionList.add(QModel(17, "What is the space complexity of a typical dynamic programming solution?", mutableListOf("O(1)", "O(n)", "O(n^2)", "It depends on the problem"), 4))
        questionList.add(QModel(18, "What is the significance of using dynamic programming in algorithms?", mutableListOf("Improves efficiency by storing solutions to subproblems", "Reduces time complexity drastically for all algorithms", "Makes the algorithm simpler", "None of the above"), 1))
        questionList.add(QModel(19, "Which of the following algorithms can be improved with dynamic programming?", mutableListOf("Dijkstra's algorithm", "Merge sort", "Floyd-Warshall algorithm", "All of the above"), 3))
        questionList.add(QModel(20, "What is the significance of the 'bottom-up' approach in dynamic programming?", mutableListOf("It builds solutions from the smallest subproblems up to the larger problems", "It is the only way to implement dynamic programming", "It requires less memory", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getClassesAndObjectsQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a class in programming?", mutableListOf("A blueprint for creating objects", "An instance of an object", "A function in programming", "None of the above"), 1))
        questionList.add(QModel(2, "What is an object?", mutableListOf("An instance of a class", "A blueprint for creating classes", "A function that returns a value", "None of the above"), 1))
        questionList.add(QModel(3, "What keyword is used to create a class in Kotlin?", mutableListOf("class", "object", "new", "define"), 1))
        questionList.add(QModel(4, "Which of the following is NOT a property of a class?", mutableListOf("Encapsulation", "Inheritance", "Polymorphism", "Compilation"), 4))
        questionList.add(QModel(5, "What is the purpose of constructors in a class?", mutableListOf("To initialize objects", "To create methods", "To destroy objects", "To inherit properties"), 1))
        questionList.add(QModel(6, "What is inheritance in object-oriented programming?", mutableListOf("A way to create new classes from existing ones", "A way to create objects", "A way to encapsulate data", "A way to overload methods"), 1))
        questionList.add(QModel(7, "What does polymorphism mean?", mutableListOf("The ability to take many forms", "The ability to create multiple classes", "The ability to inherit properties", "None of the above"), 1))
        questionList.add(QModel(8, "What is the purpose of encapsulation?", mutableListOf("To restrict access to certain components", "To allow multiple inheritance", "To create abstract classes", "None of the above"), 1))
        questionList.add(QModel(9, "Which keyword is used to create an object in Kotlin?", mutableListOf("new", "create", "object", "class"), 3))
        questionList.add(QModel(10, "What is method overloading?", mutableListOf("Defining multiple methods with the same name but different parameters", "Defining methods with different names", "Creating methods inside a class", "None of the above"), 1))
        questionList.add(QModel(11, "What is an abstract class?", mutableListOf("A class that cannot be instantiated", "A class that can be instantiated", "A class that only contains methods", "A class with no methods"), 1))
        questionList.add(QModel(12, "What is the difference between a class and a structure?", mutableListOf("Structures are value types; classes are reference types", "Classes can have methods; structures cannot", "Classes are only in OOP; structures are not", "None of the above"), 1))
        questionList.add(QModel(13, "What does the 'this' keyword refer to in a class?", mutableListOf("The current object", "The parent class", "The constructor", "The method"), 1))
        questionList.add(QModel(14, "What is the purpose of a destructor?", mutableListOf("To clean up resources when an object is no longer needed", "To initialize objects", "To create new classes", "To overload methods"), 1))
        questionList.add(QModel(15, "Which of the following is an example of encapsulation?", mutableListOf("Using private variables and public methods", "Inheriting properties from a superclass", "Overriding methods in subclasses", "Creating multiple instances of a class"), 1))
        questionList.add(QModel(16, "What is a subclass?", mutableListOf("A class that derives from another class", "A class that cannot be instantiated", "A class with no methods", "None of the above"), 1))
        questionList.add(QModel(17, "What is an interface?", mutableListOf("A contract that a class can implement", "A way to create multiple instances of a class", "A way to overload methods", "A blueprint for creating structures"), 1))
        questionList.add(QModel(18, "What is the main benefit of using object-oriented programming?", mutableListOf("Reusability and modularity", "Faster execution", "Simpler syntax", "None of the above"), 1))
        questionList.add(QModel(19, "What does the term 'data hiding' refer to?", mutableListOf("Restricting access to the internal state of an object", "Creating multiple methods with the same name", "Inheriting properties from a superclass", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following is true about a constructor?", mutableListOf("It has the same name as the class", "It can have a return type", "It is called explicitly", "It cannot be overloaded"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getInheritanceQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is inheritance in object-oriented programming?", mutableListOf("A mechanism to create a new class from an existing class", "A way to encapsulate data", "A method to implement multiple behaviors", "None of the above"), 1))
        questionList.add(QModel(2, "Which keyword is used to inherit a class in Java?", mutableListOf("extends", "inherits", "implements", "includes"), 1))
        questionList.add(QModel(3, "What is a base class?", mutableListOf("The class from which properties and methods are inherited", "A class that cannot be inherited", "A class that contains only abstract methods", "None of the above"), 1))
        questionList.add(QModel(4, "What is a derived class?", mutableListOf("A class that inherits from a base class", "A class that cannot be instantiated", "A class with only static methods", "None of the above"), 1))
        questionList.add(QModel(5, "What is the purpose of constructors in inheritance?", mutableListOf("To initialize objects of a class", "To inherit properties", "To define methods", "None of the above"), 1))
        questionList.add(QModel(6, "What happens when a derived class overrides a method of the base class?", mutableListOf("The derived class method is called instead of the base class method", "The base class method is hidden", "Both methods can be called", "None of the above"), 1))
        questionList.add(QModel(7, "Which of the following is NOT a type of inheritance?", mutableListOf("Single inheritance", "Multiple inheritance", "Multilevel inheritance", "Circular inheritance"), 4))
        questionList.add(QModel(8, "What is the main advantage of using inheritance?", mutableListOf("Code reusability", "Increased complexity", "Data hiding", "None of the above"), 1))
        questionList.add(QModel(9, "In multiple inheritance, a class can inherit from:", mutableListOf("One class", "Two or more classes", "Only abstract classes", "None of the above"), 2))
        questionList.add(QModel(10, "What is an interface in the context of inheritance?", mutableListOf("A contract that a class must follow", "A type of class that cannot be instantiated", "A mechanism to hide implementation details", "None of the above"), 1))
        questionList.add(QModel(11, "What is the 'is-a' relationship in inheritance?", mutableListOf("A derived class is a type of its base class", "A class can contain another class", "A class has multiple behaviors", "None of the above"), 1))
        questionList.add(QModel(12, "Which of the following keywords is used to prevent a class from being inherited?", mutableListOf("sealed", "final", "private", "protected"), 2))
        questionList.add(QModel(13, "What is polymorphism in the context of inheritance?", mutableListOf("The ability to present the same interface for different underlying forms", "The ability to create multiple classes from a single class", "The ability to hide data", "None of the above"), 1))
        questionList.add(QModel(14, "What is method overriding?", mutableListOf("Providing a new implementation for a method in the derived class", "Creating a new method in the base class", "Changing the return type of a method", "None of the above"), 1))
        questionList.add(QModel(15, "What is the relationship between a superclass and a subclass?", mutableListOf("The superclass is the parent class, and the subclass is the child class", "Both are the same", "The subclass can never access superclass methods", "None of the above"), 1))
        questionList.add(QModel(16, "In Java, how do you call the constructor of the base class from a derived class?", mutableListOf("Using 'super()'", "Using 'this()'", "Using 'base()'", "None of the above"), 1))
        questionList.add(QModel(17, "What is the main characteristic of multilevel inheritance?", mutableListOf("A class can inherit from another derived class", "A class can inherit from multiple classes", "A class cannot inherit from any class", "None of the above"), 1))
        questionList.add(QModel(18, "In the case of multiple inheritance, which problem can occur?", mutableListOf("Diamond problem", "Circular problem", "Abstract problem", "None of the above"), 1))
        questionList.add(QModel(19, "Can a derived class access private members of the base class?", mutableListOf("Yes, directly", "No", "Only through public methods", "None of the above"), 3))
        questionList.add(QModel(20, "Which statement about inheritance is FALSE?", mutableListOf("It promotes code reusability", "It can lead to a tight coupling", "A derived class cannot have additional properties", "It can simplify complex programs"), 3))

        setUpRecyclerView(questionList)
    }
    private fun getPolymorphismQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is polymorphism?", mutableListOf("The ability to take multiple forms", "The ability to create multiple classes", "The ability to inherit properties", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a type of polymorphism?", mutableListOf("Compile-time polymorphism", "Run-time polymorphism", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(3, "What is compile-time polymorphism?", mutableListOf("Method overloading", "Method overriding", "Dynamic binding", "None of the above"), 1))
        questionList.add(QModel(4, "What is run-time polymorphism?", mutableListOf("Method overriding", "Method overloading", "Static binding", "None of the above"), 1))
        questionList.add(QModel(5, "Which keyword is often associated with polymorphism in OOP?", mutableListOf("this", "super", "virtual", "static"), 3))
        questionList.add(QModel(6, "What is method overloading?", mutableListOf("Defining multiple methods with the same name but different parameters", "Defining methods with different names", "Overriding a base class method", "None of the above"), 1))
        questionList.add(QModel(7, "What is method overriding?", mutableListOf("Providing a new implementation of a method in a derived class", "Defining multiple methods with the same name but different parameters", "Creating a method in an abstract class", "None of the above"), 1))
        questionList.add(QModel(8, "Which of the following is NOT an advantage of polymorphism?", mutableListOf("Code reusability", "Improved performance", "Flexibility", "Maintainability"), 2))
        questionList.add(QModel(9, "What is the output of the following code snippet? 'class Animal { open fun sound() = \"Animal sound\" } class Dog : Animal() { override fun sound() = \"Bark\" } val animal: Animal = Dog() println(animal.sound())'", mutableListOf("Animal sound", "Bark", "Compile-time error", "Run-time error"), 2))
        questionList.add(QModel(10, "How does polymorphism contribute to code flexibility?", mutableListOf("By allowing methods to be used interchangeably", "By preventing method overloading", "By enforcing data hiding", "None of the above"), 1))
        questionList.add(QModel(11, "What is an abstract class?", mutableListOf("A class that cannot be instantiated", "A class that can be instantiated", "A class with all methods implemented", "None of the above"), 1))
        questionList.add(QModel(12, "What role do interfaces play in polymorphism?", mutableListOf("They define a contract that can be implemented by any class", "They are used to overload methods", "They cannot be used with polymorphism", "None of the above"), 1))
        questionList.add(QModel(13, "Which of the following allows objects of different classes to be treated as objects of a common superclass?", mutableListOf("Inheritance", "Polymorphism", "Encapsulation", "Abstraction"), 2))
        questionList.add(QModel(14, "Which of the following best describes late binding?", mutableListOf("Method calls are resolved at run-time", "Method calls are resolved at compile-time", "It refers to data hiding", "None of the above"), 1))
        questionList.add(QModel(15, "What does it mean for a method to be virtual?", mutableListOf("It can be overridden in a derived class", "It cannot be overridden", "It is only available in static classes", "None of the above"), 1))
        questionList.add(QModel(16, "How can polymorphism improve software maintenance?", mutableListOf("By allowing changes to one part of a system without affecting others", "By reducing the number of classes", "By preventing method overloading", "None of the above"), 1))
        questionList.add(QModel(17, "What is the difference between static and dynamic polymorphism?", mutableListOf("Static is resolved at compile-time; dynamic at run-time", "Static is resolved at run-time; dynamic at compile-time", "There is no difference", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following concepts is essential for implementing polymorphism?", mutableListOf("Inheritance", "Encapsulation", "Abstraction", "All of the above"), 1))
        questionList.add(QModel(19, "What is the primary purpose of using polymorphism in software design?", mutableListOf("To promote code reusability and flexibility", "To enforce strict data types", "To limit the number of objects created", "None of the above"), 1))
        questionList.add(QModel(20, "Which programming languages commonly support polymorphism?", mutableListOf("Java", "C++", "Python", "All of the above"), 4))

        setUpRecyclerView(questionList)
    }
    private fun getAbstractionQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is abstraction in object-oriented programming?", mutableListOf("Hiding the complex implementation details and showing only the essential features", "Creating multiple classes from a single class", "The ability to use the same method name in different classes", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is an example of abstraction?", mutableListOf("Using abstract classes and interfaces", "Using inheritance", "Using encapsulation", "None of the above"), 1))
        questionList.add(QModel(3, "What is the purpose of an abstract class?", mutableListOf("To provide a common interface for derived classes", "To create instances", "To hide implementation details", "None of the above"), 1))
        questionList.add(QModel(4, "What is an abstract method?", mutableListOf("A method without a body", "A method that cannot be overridden", "A method that cannot be called", "None of the above"), 1))
        questionList.add(QModel(5, "How do you declare an abstract class in Java?", mutableListOf("Using the 'abstract' keyword", "Using the 'interface' keyword", "Using the 'class' keyword only", "None of the above"), 1))
        questionList.add(QModel(6, "Which statement is TRUE regarding abstraction?", mutableListOf("It is achieved through abstract classes and interfaces", "It is the same as encapsulation", "It can only be achieved through interfaces", "None of the above"), 1))
        questionList.add(QModel(7, "What will happen if a derived class does not implement all abstract methods of its base class?", mutableListOf("It must be declared as an abstract class", "It will compile without errors", "It will cause a runtime error", "None of the above"), 1))
        questionList.add(QModel(8, "Which of the following is NOT a benefit of abstraction?", mutableListOf("Reduces code complexity", "Increases code reusability", "Hides implementation details", "Makes the code more complex"), 4))
        questionList.add(QModel(9, "In which scenario is abstraction useful?", mutableListOf("When you want to define a blueprint for future classes", "When you need to store data", "When implementing algorithms", "None of the above"), 1))
        questionList.add(QModel(10, "Can you create an object of an abstract class?", mutableListOf("Yes", "No", "Only in some languages", "Depends on the implementation"), 2))
        questionList.add(QModel(11, "What is the primary advantage of using abstraction?", mutableListOf("Hides implementation complexity", "Promotes multiple inheritance", "Enforces data hiding", "None of the above"), 1))
        questionList.add(QModel(12, "What is the relationship between abstraction and encapsulation?", mutableListOf("Abstraction focuses on hiding complexity, while encapsulation focuses on hiding data", "They are the same", "Abstraction focuses on data hiding, while encapsulation focuses on complexity", "None of the above"), 1))
        questionList.add(QModel(13, "What is an interface in the context of abstraction?", mutableListOf("A collection of abstract methods that must be implemented", "A class that cannot be instantiated", "A type of data structure", "None of the above"), 1))
        questionList.add(QModel(14, "Which keyword is used to define an interface in Java?", mutableListOf("interface", "abstract", "class", "none"), 1))
        questionList.add(QModel(15, "What happens if an abstract class has a concrete method?", mutableListOf("The method can be inherited and used by derived classes", "The method cannot be overridden", "The method will be ignored", "None of the above"), 1))
        questionList.add(QModel(16, "What is the primary purpose of using interfaces?", mutableListOf("To achieve abstraction and multiple inheritance", "To encapsulate data", "To implement encapsulation", "None of the above"), 1))
        questionList.add(QModel(17, "Which statement is FALSE about abstraction?", mutableListOf("Abstraction helps in reducing programming complexity", "Abstract classes can have constructors", "Abstract classes cannot have concrete methods", "Interfaces can be implemented by multiple classes"), 3))
        questionList.add(QModel(18, "Can an interface extend another interface?", mutableListOf("Yes", "No", "Only in some languages", "None of the above"), 1))
        questionList.add(QModel(19, "What is the key difference between an abstract class and an interface?", mutableListOf("Abstract classes can have state and behavior, while interfaces cannot", "Interfaces can have constructors, while abstract classes cannot", "Both are the same", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following allows for the implementation of abstraction in a program?", mutableListOf("Abstract classes and interfaces", "Only abstract classes", "Only interfaces", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getProcessManagementQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a process?", mutableListOf("A program in execution", "A set of instructions", "A static representation of a program", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is NOT a state of a process?", mutableListOf("New", "Ready", "Waiting", "Stopped"), 4))
        questionList.add(QModel(3, "What is the purpose of the process control block (PCB)?", mutableListOf("To store information about processes", "To manage memory allocation", "To handle input/output operations", "None of the above"), 1))
        questionList.add(QModel(4, "Which of the following describes the 'ready' state of a process?", mutableListOf("Waiting for CPU time", "Executing on the CPU", "Terminated", "None of the above"), 1))
        questionList.add(QModel(5, "What happens during a context switch?", mutableListOf("The CPU switches from one process to another", "The process state is saved", "Registers are updated", "All of the above"), 4))
        questionList.add(QModel(6, "What is a long-term scheduler?", mutableListOf("Decides which processes are admitted to the system", "Allocates CPU time to processes", "Manages memory", "None of the above"), 1))
        questionList.add(QModel(7, "What is the difference between a process and a program?", mutableListOf("A process is a running instance of a program", "A program is a set of instructions, while a process is the execution of those instructions", "Both are the same", "None of the above"), 2))
        questionList.add(QModel(8, "Which scheduling algorithm allocates the CPU to the process that has been waiting the longest?", mutableListOf("Shortest Job First", "First-Come, First-Served", "Round Robin", "Priority Scheduling"), 2))
        questionList.add(QModel(9, "What is a process state transition?", mutableListOf("The movement of a process from one state to another", "The execution of a process", "The termination of a process", "None of the above"), 1))
        questionList.add(QModel(10, "What does the term 'throughput' refer to in process management?", mutableListOf("The number of processes completed in a unit of time", "The time taken by a process to complete", "The total number of processes in the system", "None of the above"), 1))
        questionList.add(QModel(11, "What is a burst time?", mutableListOf("The time taken by a process to complete its execution", "The waiting time for a process", "The time taken to switch contexts", "None of the above"), 1))
        questionList.add(QModel(12, "Which of the following scheduling algorithms is preemptive?", mutableListOf("Shortest Job First", "Round Robin", "First-Come, First-Served", "None of the above"), 2))
        questionList.add(QModel(13, "What is meant by 'starvation' in process scheduling?", mutableListOf("A process waiting indefinitely for CPU time", "A process being terminated", "A process taking too long to complete", "None of the above"), 1))
        questionList.add(QModel(14, "What is a deadlock?", mutableListOf("A situation where two or more processes cannot proceed because each is waiting for the other to release resources", "A process that has completed execution", "A process waiting for I/O operation", "None of the above"), 1))
        questionList.add(QModel(15, "Which of the following can cause deadlock?", mutableListOf("Mutual exclusion", "Hold and wait", "No preemption", "All of the above"), 4))
        questionList.add(QModel(16, "What is the role of a short-term scheduler?", mutableListOf("To decide which process to execute next", "To allocate resources to processes", "To manage I/O operations", "None of the above"), 1))
        questionList.add(QModel(17, "What does the term 'waiting time' refer to?", mutableListOf("The total time a process spends waiting in the ready queue", "The time taken to execute a process", "The time taken to switch contexts", "None of the above"), 1))
        questionList.add(QModel(18, "What is the main goal of process management?", mutableListOf("To ensure fair allocation of CPU time among processes", "To minimize memory usage", "To reduce response time for all processes", "All of the above"), 1))
        questionList.add(QModel(19, "Which of the following is a potential solution to deadlock?", mutableListOf("Deadlock prevention", "Deadlock avoidance", "Deadlock detection and recovery", "All of the above"), 4))
        questionList.add(QModel(20, "What does 'context switching' allow a computer to do?", mutableListOf("Run multiple processes seemingly simultaneously", "Increase the speed of a single process", "Terminate processes faster", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getConcurrencyAndSynchronizationQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is concurrency in programming?", mutableListOf("Executing multiple tasks at the same time", "Executing tasks one after the other", "Sharing data between processes", "None of the above"), 1))
        questionList.add(QModel(2, "What is synchronization in the context of concurrency?", mutableListOf("Controlling access to shared resources", "Running multiple threads simultaneously", "Creating new processes", "None of the above"), 1))
        questionList.add(QModel(3, "Which of the following is a common problem in concurrent programming?", mutableListOf("Race conditions", "Deadlocks", "Starvation", "All of the above"), 4))
        questionList.add(QModel(4, "What is a race condition?", mutableListOf("When two or more threads try to change shared data at the same time", "When a thread waits indefinitely for a resource", "When a thread is blocked by another thread", "None of the above"), 1))
        questionList.add(QModel(5, "What is a deadlock?", mutableListOf("When two or more threads are waiting for each other to release resources", "When a thread completes execution", "When a thread runs without stopping", "None of the above"), 1))
        questionList.add(QModel(6, "Which keyword is used in Java to indicate that a method should be synchronized?", mutableListOf("synchronized", "lock", "thread-safe", "volatile"), 1))
        questionList.add(QModel(7, "What does the 'volatile' keyword indicate in concurrent programming?", mutableListOf("A variable may be changed by different threads", "A variable is constant", "A variable cannot be shared", "None of the above"), 1))
        questionList.add(QModel(8, "What is a semaphore?", mutableListOf("A synchronization primitive that controls access to a resource", "A type of thread", "A mechanism for creating processes", "None of the above"), 1))
        questionList.add(QModel(9, "What is a mutex?", mutableListOf("A lock that allows only one thread to access a resource at a time", "A type of variable", "A collection of threads", "None of the above"), 1))
        questionList.add(QModel(10, "What is the purpose of a condition variable?", mutableListOf("To allow threads to wait for certain conditions to be true", "To create new threads", "To synchronize two threads", "None of the above"), 1))
        questionList.add(QModel(11, "Which of the following is NOT a solution to the problem of race conditions?", mutableListOf("Mutexes", "Semaphores", "Threads", "Locks"), 3))
        questionList.add(QModel(12, "What does the term 'thread-safe' mean?", mutableListOf("A piece of code that functions correctly when accessed by multiple threads", "A code that runs in a single thread", "A code that does not require synchronization", "None of the above"), 1))
        questionList.add(QModel(13, "What is the thread lifecycle state where a thread is waiting for a resource to become available?", mutableListOf("Blocked", "Running", "Waiting", "Terminated"), 1))
        questionList.add(QModel(14, "What happens when a thread is in the 'waiting' state?", mutableListOf("It is waiting for another thread to perform a particular action", "It is executing its task", "It is not using CPU resources", "Both A and C"), 4))
        questionList.add(QModel(15, "What is a thread pool?", mutableListOf("A collection of pre-instantiated threads for executing tasks", "A group of threads waiting for a resource", "A method for creating threads", "None of the above"), 1))
        questionList.add(QModel(16, "Which of the following is a characteristic of a concurrent program?", mutableListOf("It may execute tasks in parallel", "It allows multiple tasks to run simultaneously", "It can improve resource utilization", "All of the above"), 4))
        questionList.add(QModel(17, "What is a fork-join model?", mutableListOf("A model for parallel execution where a task is divided into subtasks", "A type of thread", "A synchronization method", "None of the above"), 1))
        questionList.add(QModel(18, "What is a task in concurrent programming?", mutableListOf("A unit of work that can be executed independently", "A method that runs in a single thread", "A collection of resources", "None of the above"), 1))
        questionList.add(QModel(19, "What is the purpose of a barrier in concurrency?", mutableListOf("To synchronize the progress of threads at a certain point", "To terminate threads", "To prevent race conditions", "None of the above"), 1))
        questionList.add(QModel(20, "What is the primary goal of concurrency control?", mutableListOf("To manage access to shared resources without conflicts", "To improve program performance", "To reduce memory usage", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getMemoryManagementQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is memory management?", mutableListOf("The process of controlling and coordinating computer memory", "The process of allocating CPU time", "The process of managing input/output operations", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a technique for memory allocation?", mutableListOf("Paging", "Segmentation", "Fragmentation", "Both A and B"), 4))
        questionList.add(QModel(3, "What is a page in the context of paging?", mutableListOf("A fixed-length contiguous block of physical memory", "A variable-length block of physical memory", "A section of the hard disk", "None of the above"), 1))
        questionList.add(QModel(4, "What is the purpose of a page table?", mutableListOf("To map virtual addresses to physical addresses", "To keep track of free memory", "To manage CPU scheduling", "None of the above"), 1))
        questionList.add(QModel(5, "What is segmentation?", mutableListOf("Dividing memory into fixed-size pages", "Dividing memory into variable-size segments", "A way to organize files on a disk", "None of the above"), 2))
        questionList.add(QModel(6, "What is a memory leak?", mutableListOf("When a program consumes memory but does not release it", "When memory is allocated but not used", "When memory is freed but still in use", "None of the above"), 1))
        questionList.add(QModel(7, "What is the main disadvantage of paging?", mutableListOf("Internal fragmentation", "External fragmentation", "Slower access time", "Increased complexity"), 1))
        questionList.add(QModel(8, "What does 'thrashing' refer to?", mutableListOf("Excessive paging activity that slows down the system", "Running multiple processes simultaneously", "A method of memory allocation", "None of the above"), 1))
        questionList.add(QModel(9, "What is a frame in the context of paging?", mutableListOf("A fixed-length block of physical memory", "A section of the hard disk", "A page table entry", "None of the above"), 1))
        questionList.add(QModel(10, "Which of the following best describes the 'working set' of a process?", mutableListOf("The set of pages that are currently in use", "The set of pages that will be used in the future", "All pages of a process", "None of the above"), 1))
        questionList.add(QModel(11, "What is demand paging?", mutableListOf("Loading pages into memory only when they are needed", "Loading all pages at once", "A method of allocating memory", "None of the above"), 1))
        questionList.add(QModel(12, "Which memory management technique allows for sharing of code among processes?", mutableListOf("Segmentation", "Paging", "Swapping", "None of the above"), 1))
        questionList.add(QModel(13, "What is the purpose of the heap in memory management?", mutableListOf("To dynamically allocate memory during runtime", "To store static variables", "To hold the program's code", "None of the above"), 1))
        questionList.add(QModel(14, "Which of the following causes external fragmentation?", mutableListOf("Allocating and freeing variable-sized blocks of memory", "Fixed-size memory allocation", "Paging", "Segmentation"), 1))
        questionList.add(QModel(15, "What does the term 'swapping' refer to?", mutableListOf("Moving processes between main memory and disk", "Allocating memory to processes", "Freeing up memory", "None of the above"), 1))
        questionList.add(QModel(16, "What is 'virtual memory'?", mutableListOf("Memory that is not physically present but simulated by the operating system", "The total amount of RAM available", "The amount of memory used by the kernel", "None of the above"), 1))
        questionList.add(QModel(17, "Which of the following is a technique to prevent fragmentation?", mutableListOf("Compaction", "Segmentation", "Paging", "None of the above"), 1))
        questionList.add(QModel(18, "What does the 'base' and 'limit' register do?", mutableListOf("They define the address range of a process in memory", "They hold the current process ID", "They track memory usage", "None of the above"), 1))
        questionList.add(QModel(19, "What is a 'null pointer' in memory management?", mutableListOf("A pointer that does not point to any memory location", "A pointer pointing to a memory address of 0", "A pointer that has been freed", "None of the above"), 1))
        questionList.add(QModel(20, "What is the goal of memory management?", mutableListOf("Efficient use of memory resources", "Minimizing access time", "Preventing fragmentation", "All of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getFileSystemQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a file system?", mutableListOf("A method for storing and organizing files on a disk", "A way to manage hardware devices", "An operating system component for process management", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is NOT a file system type?", mutableListOf("FAT32", "NTFS", "ISO", "FIFO"), 4))
        questionList.add(QModel(3, "What does NTFS stand for?", mutableListOf("New Technology File System", "Network Transfer File System", "New Transfer File System", "None of the above"), 1))
        questionList.add(QModel(4, "What is the primary function of a file system?", mutableListOf("To manage data storage and retrieval", "To execute processes", "To control hardware devices", "None of the above"), 1))
        questionList.add(QModel(5, "Which file system is commonly used by Linux?", mutableListOf("FAT32", "NTFS", "ext4", "HFS+"), 3))
        questionList.add(QModel(6, "What is a directory in a file system?", mutableListOf("A container for files", "A file with metadata", "A file type", "None of the above"), 1))
        questionList.add(QModel(7, "What is the purpose of file permissions?", mutableListOf("To control access to files", "To encrypt files", "To improve file retrieval speed", "None of the above"), 1))
        questionList.add(QModel(8, "What does the term 'mounting' refer to in file systems?", mutableListOf("Making a file system accessible at a specific point in the directory tree", "Storing files on a disk", "Creating a new file system", "None of the above"), 1))
        questionList.add(QModel(9, "Which of the following file systems is best suited for flash drives?", mutableListOf("FAT32", "NTFS", "ext4", "ZFS"), 1))
        questionList.add(QModel(10, "What is a symbolic link?", mutableListOf("A file that points to another file or directory", "A type of executable file", "A file containing metadata", "None of the above"), 1))
        questionList.add(QModel(11, "What does fragmentation refer to in file systems?", mutableListOf("Scattering of file data across the disk", "Combining multiple files into one", "Creating a backup of files", "None of the above"), 1))
        questionList.add(QModel(12, "What is a file descriptor?", mutableListOf("An abstract indicator for accessing a file", "A data structure containing file metadata", "A way to encrypt files", "None of the above"), 1))
        questionList.add(QModel(13, "What is the role of a file allocation table (FAT)?", mutableListOf("To manage the storage space of files", "To provide file access permissions", "To define the structure of a file system", "None of the above"), 1))
        questionList.add(QModel(14, "Which command is used to list files in a Unix/Linux directory?", mutableListOf("ls", "dir", "list", "show"), 1))
        questionList.add(QModel(15, "What does the term 'hard link' refer to?", mutableListOf("A direct reference to the physical location of a file", "A shortcut to a file", "A temporary file", "None of the above"), 1))
        questionList.add(QModel(16, "What is the maximum size of a file in a FAT32 file system?", mutableListOf("2 GB", "4 GB", "8 GB", "No limit"), 2))
        questionList.add(QModel(17, "What is a journaling file system?", mutableListOf("A file system that keeps track of changes not yet committed to the main file system", "A system that logs user activities", "A type of encryption for files", "None of the above"), 1))
        questionList.add(QModel(18, "Which file system uses a binary tree structure for its directory?", mutableListOf("FAT", "NTFS", "ext2", "None of the above"), 2))
        questionList.add(QModel(19, "What is the purpose of the root directory?", mutableListOf("It is the top-level directory in a file system", "It stores temporary files", "It contains backup files", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following is an advantage of using a modern file system?", mutableListOf("Better data integrity and recovery", "Faster access to files", "Less disk space usage", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getCpuSchedulingAlgorithmQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is CPU scheduling?", mutableListOf("The process of determining which process runs at a given time", "The method of allocating memory", "The technique of managing input/output", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a non-preemptive scheduling algorithm?", mutableListOf("Round Robin", "First-Come, First-Served (FCFS)", "Shortest Job First (SJF)", "Priority Scheduling"), 2))
        questionList.add(QModel(3, "What is the main advantage of Round Robin scheduling?", mutableListOf("Fair allocation of CPU time", "Lowest average waiting time", "Simplicity", "None of the above"), 1))
        questionList.add(QModel(4, "What does the term 'context switch' refer to?", mutableListOf("Switching the CPU from one process to another", "Changing the priority of a process", "Moving data between memory and disk", "None of the above"), 1))
        questionList.add(QModel(5, "Which scheduling algorithm minimizes the average waiting time?", mutableListOf("First-Come, First-Served", "Shortest Job First", "Round Robin", "Priority Scheduling"), 2))
        questionList.add(QModel(6, "What is a disadvantage of the First-Come, First-Served (FCFS) algorithm?", mutableListOf("Convoy effect", "Fairness", "Simplicity", "None of the above"), 1))
        questionList.add(QModel(7, "What is the time complexity for scheduling in Round Robin?", mutableListOf("O(1)", "O(n)", "O(n log n)", "O(n^2)"), 2))
        questionList.add(QModel(8, "In Priority Scheduling, what happens when two processes have the same priority?", mutableListOf("FCFS is used", "SJF is used", "Random selection", "Both A and B"), 1))
        questionList.add(QModel(9, "What is the main drawback of Preemptive scheduling?", mutableListOf("Higher overhead due to frequent context switching", "Lower CPU utilization", "Fairness", "None of the above"), 1))
        questionList.add(QModel(10, "What is the main goal of scheduling algorithms?", mutableListOf("Maximize CPU utilization", "Minimize response time", "Ensure fairness", "All of the above"), 4))
        questionList.add(QModel(11, "What type of scheduling algorithm is the Multilevel Queue scheduling?", mutableListOf("Non-preemptive", "Preemptive", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(12, "What does the term 'starvation' refer to in scheduling?", mutableListOf("A process never gets CPU time", "A process waits indefinitely for resources", "A process is terminated", "None of the above"), 1))
        questionList.add(QModel(13, "What is the purpose of aging in scheduling?", mutableListOf("To prevent starvation", "To increase priority", "To decrease priority", "Both A and B"), 1))
        questionList.add(QModel(14, "Which scheduling algorithm is best suited for time-sharing systems?", mutableListOf("First-Come, First-Served", "Shortest Job First", "Round Robin", "Priority Scheduling"), 3))
        questionList.add(QModel(15, "What is the result of using the Shortest Job First algorithm?", mutableListOf("High throughput", "Low turnaround time", "Potential starvation", "All of the above"), 4))
        questionList.add(QModel(16, "What does the term 'turnaround time' mean?", mutableListOf("Total time taken for a process to complete", "Time taken for a process to start executing", "Time spent waiting in the queue", "None of the above"), 1))
        questionList.add(QModel(17, "In which scheduling algorithm does the CPU give priority to processes with shorter burst times?", mutableListOf("Round Robin", "First-Come, First-Served", "Shortest Job First", "Priority Scheduling"), 3))
        questionList.add(QModel(18, "What is a key feature of the Multilevel Feedback Queue scheduling algorithm?", mutableListOf("Processes can move between queues", "Processes are strictly assigned to a queue", "It uses a single queue", "None of the above"), 1))
        questionList.add(QModel(19, "Which scheduling algorithm is least favorable for interactive processes?", mutableListOf("First-Come, First-Served", "Shortest Job First", "Round Robin", "Priority Scheduling"), 1))
        questionList.add(QModel(20, "In Preemptive scheduling, which of the following can cause a context switch?", mutableListOf("Time quantum expiration", "Higher priority process arrival", "Blocking I/O", "All of the above"), 4))

        setUpRecyclerView(questionList)
    }
    private fun getDiscreteMathQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a set?", mutableListOf("A collection of distinct objects", "A type of function", "A method of sorting data", "None of the above"), 1))
        questionList.add(QModel(2, "What is the power set of a set?", mutableListOf("The set of all subsets of a set", "A set with all elements squared", "The set of all elements in a set", "None of the above"), 1))
        questionList.add(QModel(3, "What does a graph consist of?", mutableListOf("Vertices and edges", "Nodes and links", "Points and lines", "All of the above"), 1))
        questionList.add(QModel(4, "What is a directed graph?", mutableListOf("A graph with directed edges", "A graph with no edges", "A graph with weighted edges", "None of the above"), 1))
        questionList.add(QModel(5, "What is a binary relation?", mutableListOf("A set of ordered pairs", "A set of unordered pairs", "A set of elements", "None of the above"), 1))
        questionList.add(QModel(6, "What is an algorithm?", mutableListOf("A step-by-step procedure for solving a problem", "A type of data structure", "A mathematical expression", "None of the above"), 1))
        questionList.add(QModel(7, "What is the principle of mathematical induction?", mutableListOf("A method of proving statements about integers", "A technique for finding roots of equations", "A way to solve differential equations", "None of the above"), 1))
        questionList.add(QModel(8, "What is a tree in graph theory?", mutableListOf("A connected acyclic graph", "A collection of nodes", "A circular graph", "None of the above"), 1))
        questionList.add(QModel(9, "What is the degree of a vertex in a graph?", mutableListOf("The number of edges incident to the vertex", "The number of vertices connected to it", "The total number of edges in the graph", "None of the above"), 1))
        questionList.add(QModel(10, "What is a complete graph?", mutableListOf("A graph in which every pair of vertices is connected by an edge", "A graph with no edges", "A graph with at least one cycle", "None of the above"), 1))
        questionList.add(QModel(11, "What is a bipartite graph?", mutableListOf("A graph whose vertices can be divided into two disjoint sets", "A graph with no edges", "A graph with exactly two vertices", "None of the above"), 1))
        questionList.add(QModel(12, "What does a truth table represent?", mutableListOf("The output of a logical expression for all possible input combinations", "The steps of an algorithm", "The relations between different sets", "None of the above"), 1))
        questionList.add(QModel(13, "What is a combinatorial problem?", mutableListOf("A problem related to counting and arrangements", "A problem that requires mathematical induction", "A problem with infinite solutions", "None of the above"), 1))
        questionList.add(QModel(14, "What is the difference between permutation and combination?", mutableListOf("Order matters in permutation but not in combination", "Order matters in combination but not in permutation", "Both are the same", "None of the above"), 1))
        questionList.add(QModel(15, "What is a function?", mutableListOf("A relation that assigns exactly one output to each input", "A set of ordered pairs", "A method of sorting data", "None of the above"), 1))
        questionList.add(QModel(16, "What is an NP-complete problem?", mutableListOf("A problem for which no known polynomial-time solution exists", "A problem that can be solved in linear time", "A problem with a unique solution", "None of the above"), 1))
        questionList.add(QModel(17, "What is a logical statement?", mutableListOf("A declarative sentence that is either true or false", "A statement that can be proven", "A mathematical expression", "None of the above"), 1))
        questionList.add(QModel(18, "What is a Boolean algebra?", mutableListOf("An algebraic structure that captures the essence of logical operations", "A type of graph", "A set of linear equations", "None of the above"), 1))
        questionList.add(QModel(19, "What is a sequence?", mutableListOf("An ordered list of numbers", "A random collection of numbers", "A set of unique elements", "None of the above"), 1))
        questionList.add(QModel(20, "What is a recurrence relation?", mutableListOf("An equation that recursively defines a sequence", "An algebraic expression", "A method for solving equations", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getProbabilityQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is probability?", mutableListOf("The likelihood of an event occurring", "The certainty of an event occurring", "The impossibility of an event occurring", "None of the above"), 1))
        questionList.add(QModel(2, "What is the probability of an event that is certain?", mutableListOf("0", "1", "0.5", "Depends on the event"), 2))
        questionList.add(QModel(3, "What is the range of probability values?", mutableListOf("0 to 1", "1 to 10", "0 to 100", "Negative infinity to positive infinity"), 1))
        questionList.add(QModel(4, "What is the probability of rolling a 3 on a standard six-sided die?", mutableListOf("1/6", "1/3", "1/2", "1/5"), 1))
        questionList.add(QModel(5, "What does it mean if two events are independent?", mutableListOf("The occurrence of one event affects the other", "The occurrence of one event does not affect the other", "The events are mutually exclusive", "None of the above"), 2))
        questionList.add(QModel(6, "What is the complement of an event?", mutableListOf("The event does not occur", "The event occurs", "The probability of the event occurring", "None of the above"), 1))
        questionList.add(QModel(7, "If the probability of an event is 0.3, what is the probability of it not occurring?", mutableListOf("0.7", "0.3", "0.5", "0.9"), 1))
        questionList.add(QModel(8, "What is a sample space?", mutableListOf("The set of all possible outcomes", "The set of favorable outcomes", "The set of impossible outcomes", "None of the above"), 1))
        questionList.add(QModel(9, "What is the formula for calculating probability?", mutableListOf("Number of favorable outcomes / Total number of outcomes", "Total number of outcomes / Number of favorable outcomes", "Favorable outcomes + Total outcomes", "None of the above"), 1))
        questionList.add(QModel(10, "What is a mutually exclusive event?", mutableListOf("Events that cannot occur at the same time", "Events that can occur together", "Events that are dependent on each other", "None of the above"), 1))
        questionList.add(QModel(11, "What is a conditional probability?", mutableListOf("The probability of an event given that another event has occurred", "The probability of two events occurring together", "The probability of an event not occurring", "None of the above"), 1))
        questionList.add(QModel(12, "What is the probability of drawing an Ace from a standard deck of 52 cards?", mutableListOf("1/52", "1/13", "1/26", "1/4"), 2))
        questionList.add(QModel(13, "What does the term 'expected value' refer to?", mutableListOf("The average outcome of a probability distribution", "The most likely outcome", "The worst-case scenario", "None of the above"), 1))
        questionList.add(QModel(14, "What is Bayes' theorem used for?", mutableListOf("Calculating conditional probabilities", "Calculating expected values", "Calculating independent probabilities", "None of the above"), 1))
        questionList.add(QModel(15, "If two events A and B are independent, what is P(A and B)?", mutableListOf("P(A) + P(B)", "P(A) * P(B)", "P(A) - P(B)", "None of the above"), 2))
        questionList.add(QModel(16, "What is the probability of flipping a fair coin and getting heads?", mutableListOf("1/2", "1/3", "1/4", "1/6"), 1))
        questionList.add(QModel(17, "In probability, what does a 'random variable' represent?", mutableListOf("A variable whose value is determined by chance", "A fixed value", "A constant variable", "None of the above"), 1))
        questionList.add(QModel(18, "What is the difference between discrete and continuous random variables?", mutableListOf("Discrete can take on countable values; continuous can take on any value", "Discrete can take on any value; continuous can take on countable values", "Both are the same", "None of the above"), 1))
        questionList.add(QModel(19, "What is a probability distribution?", mutableListOf("A function that describes the likelihood of different outcomes", "A collection of outcomes", "The average of outcomes", "None of the above"), 1))
        questionList.add(QModel(20, "In a normal distribution, what percentage of data falls within one standard deviation of the mean?", mutableListOf("68%", "50%", "95%", "99%"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getGraphTheoryQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a graph?", mutableListOf("A collection of nodes and edges", "A collection of nodes only", "A collection of edges only", "None of the above"), 1))
        questionList.add(QModel(2, "What is the degree of a vertex in a graph?", mutableListOf("The number of edges connected to the vertex", "The total number of vertices in the graph", "The maximum distance from the vertex", "None of the above"), 1))
        questionList.add(QModel(3, "What is a directed graph?", mutableListOf("A graph where edges have a direction", "A graph where edges are bidirectional", "A graph with no edges", "None of the above"), 1))
        questionList.add(QModel(4, "What is a cycle in a graph?", mutableListOf("A path that starts and ends at the same vertex", "A path with no repeated vertices", "A path connecting all vertices", "None of the above"), 1))
        questionList.add(QModel(5, "What does it mean for a graph to be connected?", mutableListOf("There is a path between every pair of vertices", "There is at least one cycle", "All vertices are isolated", "None of the above"), 1))
        questionList.add(QModel(6, "What is a weighted graph?", mutableListOf("A graph where edges have weights assigned to them", "A graph with equal edge lengths", "A graph with no edges", "None of the above"), 1))
        questionList.add(QModel(7, "Which algorithm is used to find the shortest path in a weighted graph?", mutableListOf("Dijkstra's algorithm", "Kruskal's algorithm", "Prim's algorithm", "Floyd-Warshall algorithm"), 1))
        questionList.add(QModel(8, "What is a tree in graph theory?", mutableListOf("A connected acyclic graph", "A connected graph with cycles", "A disconnected graph", "None of the above"), 1))
        questionList.add(QModel(9, "In a complete graph, how many edges are there?", mutableListOf("n(n-1)/2", "n(n+1)/2", "n^2", "n-1"), 1))
        questionList.add(QModel(10, "What is the time complexity of BFS (Breadth-First Search)?", mutableListOf("O(V + E)", "O(V^2)", "O(E log V)", "O(V log V)"), 1))
        questionList.add(QModel(11, "What is an adjacency matrix?", mutableListOf("A square matrix used to represent a graph", "A list of edges in a graph", "A list of vertices", "None of the above"), 1))
        questionList.add(QModel(12, "What is the main difference between BFS and DFS?", mutableListOf("BFS explores all neighbors at the present depth prior to moving on to nodes at the next depth level; DFS explores as far as possible along each branch before backtracking", "BFS is faster than DFS", "DFS uses a queue; BFS uses a stack", "None of the above"), 1))
        questionList.add(QModel(13, "What is a bipartite graph?", mutableListOf("A graph whose vertices can be divided into two disjoint sets", "A graph with two cycles", "A graph with all vertices connected", "None of the above"), 1))
        questionList.add(QModel(14, "Which algorithm is used for finding the Minimum Spanning Tree (MST)?", mutableListOf("Kruskal's algorithm", "Dijkstra's algorithm", "Prim's algorithm", "Both A and C"), 4))
        questionList.add(QModel(15, "What is a path in a graph?", mutableListOf("A sequence of edges connecting a sequence of vertices", "A single vertex", "A cycle in the graph", "None of the above"), 1))
        questionList.add(QModel(16, "What does it mean for a graph to be acyclic?", mutableListOf("It has no cycles", "It has at least one cycle", "All vertices are connected", "None of the above"), 1))
        questionList.add(QModel(17, "What is an Eulerian path?", mutableListOf("A path that visits every edge exactly once", "A path that visits every vertex exactly once", "A path with no cycles", "None of the above"), 1))
        questionList.add(QModel(18, "What is a Hamiltonian cycle?", mutableListOf("A cycle that visits every vertex exactly once and returns to the starting vertex", "A cycle that visits every edge exactly once", "A cycle with repeated vertices", "None of the above"), 1))
        questionList.add(QModel(19, "What is the chromatic number of a graph?", mutableListOf("The minimum number of colors needed to color the vertices such that no two adjacent vertices share the same color", "The total number of vertices", "The total number of edges", "None of the above"), 1))
        questionList.add(QModel(20, "What is a planar graph?", mutableListOf("A graph that can be drawn on a plane without edges crossing", "A graph with a cycle", "A graph that cannot be drawn", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getModularArithmeticQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is modular arithmetic?", mutableListOf("A system of arithmetic for integers where numbers wrap around upon reaching a certain value", "A method of adding fractions", "A type of complex number arithmetic", "None of the above"), 1))
        questionList.add(QModel(2, "What is the modulus in modular arithmetic?", mutableListOf("The value at which numbers wrap around", "The total number of elements in a set", "A type of prime number", "None of the above"), 1))
        questionList.add(QModel(3, "What is the result of 10 mod 3?", mutableListOf("1", "2", "3", "0"), 2))
        questionList.add(QModel(4, "Which of the following is true for modular addition?", mutableListOf("(a + b) mod n = [(a mod n) + (b mod n)] mod n", "It always gives a result of 0", "It cannot be used for negative numbers", "None of the above"), 1))
        questionList.add(QModel(5, "What is the result of 15 mod 4?", mutableListOf("3", "4", "2", "1"), 1))
        questionList.add(QModel(6, "Which operation cannot be performed directly in modular arithmetic?", mutableListOf("Division", "Addition", "Multiplication", "Subtraction"), 1))
        questionList.add(QModel(7, "What is the modular inverse?", mutableListOf("An integer b such that (a * b) mod n = 1", "The result of dividing a number by n", "The same as the modulus", "None of the above"), 1))
        questionList.add(QModel(8, "What is the property of modular multiplication?", mutableListOf("(a * b) mod n = [(a mod n) * (b mod n)] mod n", "It is always equal to n", "It can only be performed on prime numbers", "None of the above"), 1))
        questionList.add(QModel(9, "What does it mean for two numbers to be congruent modulo n?", mutableListOf("They leave the same remainder when divided by n", "They are equal", "They are both prime", "None of the above"), 1))
        questionList.add(QModel(10, "What is the result of 18 mod 5?", mutableListOf("3", "4", "5", "2"), 1))
        questionList.add(QModel(11, "What is a congruence class?", mutableListOf("A set of integers that are congruent to each other modulo n", "A single integer", "An irrational number", "None of the above"), 1))
        questionList.add(QModel(12, "How is modular exponentiation calculated?", mutableListOf("Using repeated squaring to reduce large powers modulo n", "By simply taking the power and reducing it directly", "It cannot be calculated", "None of the above"), 1))
        questionList.add(QModel(13, "What is Fermat's Little Theorem?", mutableListOf("If p is a prime and a is an integer not divisible by p, then a^(p-1) ≡ 1 (mod p)", "A theorem that applies to even numbers only", "It states that all numbers are prime", "None of the above"), 1))
        questionList.add(QModel(14, "What is the result of (7 + 8) mod 6?", mutableListOf("3", "1", "0", "2"), 2))
        questionList.add(QModel(15, "If a ≡ b (mod n), which of the following is true?", mutableListOf("a and b have the same remainder when divided by n", "a is equal to b", "a is greater than b", "None of the above"), 1))
        questionList.add(QModel(16, "What is the period of a modular sequence?", mutableListOf("The length of the sequence before it starts repeating", "The maximum number in the sequence", "The minimum number in the sequence", "None of the above"), 1))
        questionList.add(QModel(17, "What is the significance of the modulus in cryptography?", mutableListOf("It helps ensure data integrity and security", "It is irrelevant to cryptography", "It only applies to addition", "None of the above"), 1))
        questionList.add(QModel(18, "What is the Chinese Remainder Theorem used for?", mutableListOf("Solving systems of simultaneous congruences", "Finding the sum of integers", "Calculating the average", "None of the above"), 1))
        questionList.add(QModel(19, "What is the result of 30 mod 7?", mutableListOf("2", "4", "3", "1"), 2))
        questionList.add(QModel(20, "What is an application of modular arithmetic?", mutableListOf("Cryptography", "Computer graphics", "Hashing algorithms", "All of the above"), 4))

        setUpRecyclerView(questionList)
    }
    private fun getNumberTheoryQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a prime number?", mutableListOf("A number greater than 1 that has no positive divisors other than 1 and itself", "A number that can be divided evenly by 2", "A number that ends in 0 or 5", "None of the above"), 1))
        questionList.add(QModel(2, "What is the greatest common divisor (GCD)?", mutableListOf("The largest positive integer that divides two or more integers without leaving a remainder", "The smallest positive integer that divides two or more integers", "The sum of the divisors of a number", "None of the above"), 1))
        questionList.add(QModel(3, "What is a composite number?", mutableListOf("A positive integer that has at least one positive divisor other than one or itself", "A number that cannot be divided", "A number that is prime", "None of the above"), 1))
        questionList.add(QModel(4, "What is the least common multiple (LCM)?", mutableListOf("The smallest positive integer that is divisible by two or more integers", "The largest integer that divides two or more integers", "The sum of two integers", "None of the above"), 1))
        questionList.add(QModel(5, "What is a perfect number?", mutableListOf("A positive integer that is equal to the sum of its proper positive divisors", "A prime number", "A composite number", "None of the above"), 1))
        questionList.add(QModel(6, "What is modular arithmetic?", mutableListOf("A system of arithmetic for integers where numbers wrap around after reaching a certain value", "A type of complex number arithmetic", "Arithmetic involving fractions", "None of the above"), 1))
        questionList.add(QModel(7, "What is the fundamental theorem of arithmetic?", mutableListOf("Every integer greater than 1 can be uniquely factored into prime numbers", "All numbers are prime", "Prime numbers can be divided", "None of the above"), 1))
        questionList.add(QModel(8, "What is a Fibonacci sequence?", mutableListOf("A sequence where each number is the sum of the two preceding ones", "A sequence of prime numbers", "A random sequence of numbers", "None of the above"), 1))
        questionList.add(QModel(9, "What is a congruence relation?", mutableListOf("A relation that expresses that two numbers leave the same remainder when divided by a third number", "A relation that states two numbers are equal", "A type of inequality", "None of the above"), 1))
        questionList.add(QModel(10, "What is a divisor?", mutableListOf("An integer that divides another integer without leaving a remainder", "Any integer", "A prime number", "None of the above"), 1))
        questionList.add(QModel(11, "What is a residue class?", mutableListOf("A set of integers that all have the same remainder when divided by a given integer", "A group of prime numbers", "A collection of composite numbers", "None of the above"), 1))
        questionList.add(QModel(12, "What is the Chinese Remainder Theorem?", mutableListOf("A theorem that provides a solution to simultaneous congruences with pairwise coprime moduli", "A theorem that states all numbers are composite", "A theorem regarding prime numbers only", "None of the above"), 1))
        questionList.add(QModel(13, "What is a perfect square?", mutableListOf("A number that can be expressed as the square of an integer", "A prime number", "A composite number", "None of the above"), 1))
        questionList.add(QModel(14, "What is an integer?", mutableListOf("A whole number that can be positive, negative, or zero", "A number with a decimal point", "A prime number", "None of the above"), 1))
        questionList.add(QModel(15, "What is an irrational number?", mutableListOf("A number that cannot be expressed as a simple fraction", "A whole number", "A number that can be written as a ratio", "None of the above"), 1))
        questionList.add(QModel(16, "What does it mean for two numbers to be coprime?", mutableListOf("They have no common positive integer factors other than 1", "They are both prime", "They are both even", "None of the above"), 1))
        questionList.add(QModel(17, "What is a rational number?", mutableListOf("A number that can be expressed as the quotient of two integers", "A whole number", "A prime number", "None of the above"), 1))
        questionList.add(QModel(18, "What is the Sieve of Eratosthenes?", mutableListOf("An ancient algorithm for finding all prime numbers up to a specified integer", "A method for dividing numbers", "A technique for summing sequences", "None of the above"), 1))
        questionList.add(QModel(19, "What is a Pythagorean triple?", mutableListOf("A set of three positive integers a, b, and c that satisfy the equation a² + b² = c²", "A set of prime numbers", "A sequence of Fibonacci numbers", "None of the above"), 1))
        questionList.add(QModel(20, "What is a binomial coefficient?", mutableListOf("The number of ways to choose k elements from a set of n elements", "The product of two integers", "A type of prime number", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getStatisticsQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is the mean of a set of numbers?", mutableListOf("The average of the numbers", "The middle value", "The most frequent value", "None of the above"), 1))
        questionList.add(QModel(2, "What is the median of a data set?", mutableListOf("The average value", "The middle value when arranged in order", "The most frequent value", "None of the above"), 2))
        questionList.add(QModel(3, "What is the mode of a set of numbers?", mutableListOf("The number that appears most frequently", "The average of the numbers", "The middle number in a sorted list", "None of the above"), 1))
        questionList.add(QModel(4, "What is variance?", mutableListOf("A measure of how spread out numbers are", "The average of a data set", "The middle value of a data set", "None of the above"), 1))
        questionList.add(QModel(5, "What is standard deviation?", mutableListOf("The square root of the variance", "A measure of central tendency", "The most common value in a dataset", "None of the above"), 1))
        questionList.add(QModel(6, "What is a probability distribution?", mutableListOf("A function that describes the likelihood of different outcomes", "The average of a dataset", "The sum of all values", "None of the above"), 1))
        questionList.add(QModel(7, "What does a normal distribution look like?", mutableListOf("A bell-shaped curve", "A uniform distribution", "A skewed distribution", "None of the above"), 1))
        questionList.add(QModel(8, "What is a sample in statistics?", mutableListOf("A subset of a population", "The entire population", "The average of the population", "None of the above"), 1))
        questionList.add(QModel(9, "What is the purpose of hypothesis testing?", mutableListOf("To make inferences about populations", "To find the mean of a dataset", "To calculate standard deviation", "None of the above"), 1))
        questionList.add(QModel(10, "What is a p-value?", mutableListOf("The probability of observing results as extreme as the observed results, given that the null hypothesis is true", "The average of a dataset", "A measure of central tendency", "None of the above"), 1))
        questionList.add(QModel(11, "What does it mean if a result is statistically significant?", mutableListOf("It is unlikely to have occurred by chance", "It is the average of a dataset", "It has no real-world implications", "None of the above"), 1))
        questionList.add(QModel(12, "What is a confidence interval?", mutableListOf("A range of values that is likely to contain the population parameter", "The average of the sample", "The standard deviation of the sample", "None of the above"), 1))
        questionList.add(QModel(13, "What is a scatter plot used for?", mutableListOf("To show the relationship between two variables", "To display the frequency of a single variable", "To show the distribution of a dataset", "None of the above"), 1))
        questionList.add(QModel(14, "What is correlation?", mutableListOf("A measure of the relationship between two variables", "The average of two numbers", "The spread of a dataset", "None of the above"), 1))
        questionList.add(QModel(15, "What is regression analysis used for?", mutableListOf("To predict the value of a variable based on the value of another variable", "To find the average of a dataset", "To calculate variance", "None of the above"), 1))
        questionList.add(QModel(16, "What is outlier in statistics?", mutableListOf("A value that is significantly different from other values", "The average value", "A common value", "None of the above"), 1))
        questionList.add(QModel(17, "What is the range of a dataset?", mutableListOf("The difference between the highest and lowest values", "The average of the dataset", "The middle value", "None of the above"), 1))
        questionList.add(QModel(18, "What is qualitative data?", mutableListOf("Data that can be categorized based on characteristics", "Data that is numerical", "Data that has a mean", "None of the above"), 1))
        questionList.add(QModel(19, "What is quantitative data?", mutableListOf("Data that is numerical and can be measured", "Data that can be categorized", "Data that has a mode", "None of the above"), 1))
        questionList.add(QModel(20, "What is an independent variable?", mutableListOf("The variable that is manipulated or controlled", "The variable that is measured", "The variable that is kept constant", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getLinearAlgebraQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a vector?", mutableListOf("A quantity with both magnitude and direction", "A number with no direction", "A point in space", "None of the above"), 1))
        questionList.add(QModel(2, "What is a matrix?", mutableListOf("A rectangular array of numbers", "A single number", "A vector with no direction", "None of the above"), 1))
        questionList.add(QModel(3, "What does it mean for a matrix to be invertible?", mutableListOf("There exists another matrix that can multiply it to produce the identity matrix", "The matrix has no determinant", "The matrix is singular", "None of the above"), 1))
        questionList.add(QModel(4, "What is the determinant of a matrix?", mutableListOf("A scalar value that provides information about the matrix", "A vector that defines the matrix", "A sum of all elements in the matrix", "None of the above"), 1))
        questionList.add(QModel(5, "What is a linear transformation?", mutableListOf("A function that maps vectors to vectors and preserves vector addition and scalar multiplication", "A transformation that only scales vectors", "A function that maps numbers to numbers", "None of the above"), 1))
        questionList.add(QModel(6, "What is the dot product of two vectors?", mutableListOf("A scalar value obtained from multiplying corresponding components and summing the results", "A vector resulting from multiplying two vectors", "The angle between two vectors", "None of the above"), 1))
        questionList.add(QModel(7, "What is the cross product of two vectors?", mutableListOf("A vector that is perpendicular to both of the original vectors", "A scalar value", "The sum of two vectors", "None of the above"), 1))
        questionList.add(QModel(8, "What does it mean for vectors to be linearly independent?", mutableListOf("No vector can be written as a linear combination of the others", "All vectors point in the same direction", "Vectors have the same magnitude", "None of the above"), 1))
        questionList.add(QModel(9, "What is an eigenvalue?", mutableListOf("A scalar that describes how much a transformation stretches or compresses a vector", "A vector that has the same direction as the original vector", "The determinant of a matrix", "None of the above"), 1))
        questionList.add(QModel(10, "What is the rank of a matrix?", mutableListOf("The dimension of the vector space generated by its rows or columns", "The number of elements in the matrix", "The number of rows in the matrix", "None of the above"), 1))
        questionList.add(QModel(11, "What is the null space of a matrix?", mutableListOf("The set of all vectors that, when multiplied by the matrix, produce the zero vector", "The space of all eigenvalues", "The set of all invertible matrices", "None of the above"), 1))
        questionList.add(QModel(12, "What is a homogeneous system of equations?", mutableListOf("A system where all constant terms are zero", "A system with at least one solution", "A system with no solutions", "None of the above"), 1))
        questionList.add(QModel(13, "What does it mean for a system of equations to be consistent?", mutableListOf("There is at least one solution", "There are no solutions", "The equations are independent", "None of the above"), 1))
        questionList.add(QModel(14, "What is a basis in linear algebra?", mutableListOf("A set of linearly independent vectors that span a vector space", "A set of all vectors in a vector space", "A single vector in a space", "None of the above"), 1))
        questionList.add(QModel(15, "What is the purpose of Gaussian elimination?", mutableListOf("To solve systems of linear equations", "To find eigenvalues", "To calculate determinants", "None of the above"), 1))
        questionList.add(QModel(16, "What is a scalar?", mutableListOf("A single number", "A vector with direction", "A matrix with multiple elements", "None of the above"), 1))
        questionList.add(QModel(17, "What is the difference between a row vector and a column vector?", mutableListOf("A row vector is a 1 x n matrix, while a column vector is an n x 1 matrix", "There is no difference", "Both represent the same quantity", "None of the above"), 1))
        questionList.add(QModel(18, "What is matrix multiplication?", mutableListOf("A process of multiplying rows by columns", "A process of adding matrices together", "A function that finds determinants", "None of the above"), 1))
        questionList.add(QModel(19, "What is the transpose of a matrix?", mutableListOf("A matrix obtained by swapping rows and columns", "A matrix with all elements multiplied by -1", "A matrix with no elements", "None of the above"), 1))
        questionList.add(QModel(20, "What is the relationship between a matrix and its inverse?", mutableListOf("Multiplying a matrix by its inverse yields the identity matrix", "The inverse matrix has no relationship", "Both matrices are equal", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getSqlBasicsQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does SQL stand for?", mutableListOf("Structured Query Language", "Simple Query Language", "Sequential Query Language", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is used to retrieve data from a database?", mutableListOf("SELECT", "INSERT", "UPDATE", "DELETE"), 1))
        questionList.add(QModel(3, "What is the purpose of the WHERE clause in SQL?", mutableListOf("To filter records based on a specified condition", "To sort the records", "To group records", "None of the above"), 1))
        questionList.add(QModel(4, "What SQL statement is used to create a new table?", mutableListOf("CREATE TABLE", "NEW TABLE", "ADD TABLE", "INSERT TABLE"), 1))
        questionList.add(QModel(5, "Which command is used to delete a table in SQL?", mutableListOf("DROP TABLE", "DELETE TABLE", "REMOVE TABLE", "CLEAR TABLE"), 1))
        questionList.add(QModel(6, "What is a primary key?", mutableListOf("A unique identifier for a record in a table", "A foreign key from another table", "A column that can have duplicate values", "None of the above"), 1))
        questionList.add(QModel(7, "What is the purpose of the GROUP BY clause?", mutableListOf("To group rows that have the same values in specified columns", "To order the results", "To filter results", "None of the above"), 1))
        questionList.add(QModel(8, "Which SQL statement is used to update data in a database?", mutableListOf("UPDATE", "EDIT", "CHANGE", "MODIFY"), 1))
        questionList.add(QModel(9, "What is a foreign key?", mutableListOf("A key that links two tables together", "A unique identifier in a table", "A key that can have duplicate values", "None of the above"), 1))
        questionList.add(QModel(10, "What does the COUNT() function do?", mutableListOf("Returns the number of rows that match a specified criteria", "Adds up numeric values", "Returns the average of a set of values", "None of the above"), 1))
        questionList.add(QModel(11, "What is the purpose of the JOIN clause?", mutableListOf("To combine rows from two or more tables", "To filter rows", "To sort the results", "None of the above"), 1))
        questionList.add(QModel(12, "Which keyword is used to sort the result set in SQL?", mutableListOf("ORDER BY", "SORT BY", "GROUP BY", "FILTER BY"), 1))
        questionList.add(QModel(13, "What is the purpose of the DISTINCT keyword?", mutableListOf("To return only unique values", "To sort the result set", "To group rows", "None of the above"), 1))
        questionList.add(QModel(14, "Which command is used to add a new row to a table?", mutableListOf("INSERT INTO", "ADD ROW", "NEW ROW", "APPEND"), 1))
        questionList.add(QModel(15, "What is a view in SQL?", mutableListOf("A virtual table based on the result set of a SELECT query", "A physical table", "A type of index", "None of the above"), 1))
        questionList.add(QModel(16, "What does the LIKE operator do?", mutableListOf("Searches for a specified pattern in a column", "Checks for equality", "Filters records", "None of the above"), 1))
        questionList.add(QModel(17, "What is normalization in database design?", mutableListOf("The process of organizing data to minimize redundancy", "The process of adding data", "The process of retrieving data", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following is NOT a type of JOIN?", mutableListOf("INNER JOIN", "OUTER JOIN", "CROSS JOIN", "FILTER JOIN"), 4))
        questionList.add(QModel(19, "What is a stored procedure?", mutableListOf("A set of SQL statements stored in the database", "A single SQL statement", "A temporary table", "None of the above"), 1))
        questionList.add(QModel(20, "What is the purpose of the LIMIT clause?", mutableListOf("To specify the maximum number of records to return", "To sort records", "To filter records", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getNormalizationQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is normalization in databases?", mutableListOf("The process of organizing data to reduce redundancy", "The process of increasing data redundancy", "A way to backup data", "None of the above"), 1))
        questionList.add(QModel(2, "What is the primary purpose of normalization?", mutableListOf("To minimize data redundancy and improve data integrity", "To maximize data redundancy", "To speed up query execution", "None of the above"), 1))
        questionList.add(QModel(3, "Which of the following is a normal form?", mutableListOf("1NF", "2NF", "3NF", "All of the above"), 4))
        questionList.add(QModel(4, "What does 1NF (First Normal Form) ensure?", mutableListOf("Each column contains atomic values and each row is unique", "No null values are allowed", "All data is stored in one table", "None of the above"), 1))
        questionList.add(QModel(5, "What is a functional dependency?", mutableListOf("A relationship between attributes in a relation", "A way to join two tables", "A method to update records", "None of the above"), 1))
        questionList.add(QModel(6, "Which normal form requires that a relation is in 1NF and all non-key attributes are fully functionally dependent on the primary key?", mutableListOf("2NF", "3NF", "BCNF", "1NF"), 1))
        questionList.add(QModel(7, "What does 3NF (Third Normal Form) eliminate?", mutableListOf("Transitive dependencies", "Partial dependencies", "Redundant data", "None of the above"), 1))
        questionList.add(QModel(8, "What is denormalization?", mutableListOf("The process of intentionally introducing redundancy into a database", "A process to eliminate redundancy", "The same as normalization", "None of the above"), 1))
        questionList.add(QModel(9, "What is an example of a violation of 1NF?", mutableListOf("Storing multiple values in a single column", "Having duplicate rows", "Not having a primary key", "None of the above"), 1))
        questionList.add(QModel(10, "Which normal form is concerned with removing transitive dependencies?", mutableListOf("1NF", "2NF", "3NF", "BCNF"), 3))
        questionList.add(QModel(11, "What is the benefit of normalizing a database?", mutableListOf("Improved data integrity", "Reduced redundancy", "More efficient queries", "All of the above"), 4))
        questionList.add(QModel(12, "In which normal form are all non-prime attributes dependent only on the primary key?", mutableListOf("1NF", "2NF", "3NF", "BCNF"), 3))
        questionList.add(QModel(13, "What is the drawback of normalization?", mutableListOf("Complex queries due to multiple tables", "Increased data redundancy", "Reduced data integrity", "None of the above"), 1))
        questionList.add(QModel(14, "Which of the following is not a benefit of normalization?", mutableListOf("Improved data integrity", "Better performance on queries", "Increased data redundancy", "Elimination of anomalies"), 3))
        questionList.add(QModel(15, "What type of anomalies can normalization help prevent?", mutableListOf("Insertion, deletion, and update anomalies", "Only update anomalies", "Only deletion anomalies", "None of the above"), 1))
        questionList.add(QModel(16, "What is a primary key?", mutableListOf("A unique identifier for a record in a table", "A column that can have duplicate values", "A key used to link tables", "None of the above"), 1))
        questionList.add(QModel(17, "What is the goal of database design?", mutableListOf("To create a normalized database structure", "To create as many tables as possible", "To minimize the number of attributes", "None of the above"), 1))
        questionList.add(QModel(18, "In what scenario might denormalization be beneficial?", mutableListOf("When read performance needs to be improved", "When data integrity is not a concern", "When the database has very few tables", "None of the above"), 1))
        questionList.add(QModel(19, "Which of the following is a sign of a poorly normalized database?", mutableListOf("Data is duplicated across multiple tables", "All tables are linked correctly", "There are no null values", "None of the above"), 1))
        questionList.add(QModel(20, "What is a composite key?", mutableListOf("A primary key made up of two or more columns", "A key that has a single column", "A key that is not unique", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getIndexingQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is an index in a database?", mutableListOf("A data structure that improves the speed of data retrieval", "A way to store data", "A method to backup data", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a type of index?", mutableListOf("Primary index", "Secondary index", "Unique index", "All of the above"), 4))
        questionList.add(QModel(3, "What is a primary index?", mutableListOf("An index based on the primary key of a table", "An index that allows duplicate values", "An index that is not unique", "None of the above"), 1))
        questionList.add(QModel(4, "How does indexing improve query performance?", mutableListOf("By reducing the amount of data scanned", "By increasing data redundancy", "By creating duplicate data", "None of the above"), 1))
        questionList.add(QModel(5, "What is a clustered index?", mutableListOf("An index that defines the physical order of data in a table", "An index that is separate from the data", "An index that does not allow duplicates", "None of the above"), 1))
        questionList.add(QModel(6, "What is a non-clustered index?", mutableListOf("An index that does not change the physical order of data", "An index that organizes data physically", "An index that can only be created on primary keys", "None of the above"), 1))
        questionList.add(QModel(7, "Which of the following is true about unique indexes?", mutableListOf("They do not allow duplicate values", "They can have null values", "They can be created on non-primary keys", "All of the above"), 4))
        questionList.add(QModel(8, "What is the downside of using indexes?", mutableListOf("Increased storage space and slower write operations", "Improved read performance", "Reduced query execution time", "None of the above"), 1))
        questionList.add(QModel(9, "When should you consider creating an index?", mutableListOf("When a table has a high number of rows", "When frequently querying a column", "When optimizing for read-heavy operations", "All of the above"), 4))
        questionList.add(QModel(10, "What does the term 'indexing overhead' refer to?", mutableListOf("The extra resources needed to maintain the index", "The time taken to create an index", "The amount of data indexed", "None of the above"), 1))
        questionList.add(QModel(11, "What is a bitmap index?", mutableListOf("An index that uses bitmap vectors to represent data", "An index that is always clustered", "An index that only works with primary keys", "None of the above"), 1))
        questionList.add(QModel(12, "Which type of index is best suited for columns with low cardinality?", mutableListOf("Clustered index", "Non-clustered index", "Bitmap index", "Unique index"), 3))
        questionList.add(QModel(13, "What is an indexed view?", mutableListOf("A view that has an index applied to it", "A view that does not use indexes", "A view that displays only indexed data", "None of the above"), 1))
        questionList.add(QModel(14, "Which command is used to create an index in SQL?", mutableListOf("CREATE INDEX", "ADD INDEX", "INDEX CREATE", "None of the above"), 1))
        questionList.add(QModel(15, "What is the purpose of a full-text index?", mutableListOf("To enable complex queries on text data", "To speed up numeric searches", "To improve performance for small datasets", "None of the above"), 1))
        questionList.add(QModel(16, "How does a composite index work?", mutableListOf("By indexing multiple columns together", "By indexing each column separately", "By creating a single index for all tables", "None of the above"), 1))
        questionList.add(QModel(17, "What is the effect of dropping an index on a table?", mutableListOf("The index is removed, which may slow down queries", "The data in the table is deleted", "The table is no longer accessible", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following is an example of a trade-off with indexing?", mutableListOf("Faster reads but slower writes", "Slower reads but faster writes", "No effect on performance", "None of the above"), 1))
        questionList.add(QModel(19, "What is a covering index?", mutableListOf("An index that contains all the columns needed for a query", "An index that covers multiple tables", "An index that only includes primary key columns", "None of the above"), 1))
        questionList.add(QModel(20, "When is it beneficial to use an index?", mutableListOf("When searching for specific values in large tables", "When inserting bulk data", "When updating records frequently", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getAcidPropertiesQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does ACID stand for?", mutableListOf("Atomicity, Consistency, Isolation, Durability", "Atomicity, Control, Isolation, Durability", "Atomicity, Consistency, Integrity, Durability", "None of the above"), 1))
        questionList.add(QModel(2, "What does Atomicity ensure in a transaction?", mutableListOf("All operations in a transaction are completed successfully or none at all", "Data is consistent before and after the transaction", "Transactions are executed in isolation", "None of the above"), 1))
        questionList.add(QModel(3, "Which ACID property guarantees that the database will remain in a consistent state before and after a transaction?", mutableListOf("Consistency", "Atomicity", "Isolation", "Durability"), 1))
        questionList.add(QModel(4, "What does Isolation mean in the context of ACID properties?", mutableListOf("Transactions are executed independently without interference", "Transactions are always completed successfully", "Transactions are logged for recovery", "None of the above"), 1))
        questionList.add(QModel(5, "What does Durability ensure in a transaction?", mutableListOf("Once a transaction is committed, it remains so even in the event of a system failure", "Transactions are executed in isolation", "All transactions are reversible", "None of the above"), 1))
        questionList.add(QModel(6, "Which of the following is NOT an ACID property?", mutableListOf("Consistency", "Atomicity", "Integrity", "Durability"), 3))
        questionList.add(QModel(7, "What happens if a transaction violates the Atomicity property?", mutableListOf("The entire transaction is rolled back", "Only some operations are rolled back", "The transaction is committed", "None of the above"), 1))
        questionList.add(QModel(8, "What is a potential issue that the Isolation property aims to prevent?", mutableListOf("Dirty reads, non-repeatable reads, and phantom reads", "Loss of data", "Slow performance", "None of the above"), 1))
        questionList.add(QModel(9, "How does Durability affect database recovery?", mutableListOf("It ensures that committed transactions are not lost during recovery", "It allows for rollback of transactions", "It does not impact recovery", "None of the above"), 1))
        questionList.add(QModel(10, "Which property would prevent two transactions from conflicting with each other?", mutableListOf("Isolation", "Atomicity", "Consistency", "Durability"), 1))
        questionList.add(QModel(11, "What is meant by a 'commit' in the context of ACID properties?", mutableListOf("To finalize a transaction and make changes permanent", "To undo a transaction", "To lock a database", "None of the above"), 1))
        questionList.add(QModel(12, "In a scenario where a power failure occurs during a transaction, which ACID property ensures that data remains safe?", mutableListOf("Durability", "Consistency", "Isolation", "Atomicity"), 1))
        questionList.add(QModel(13, "Which ACID property is most closely related to maintaining data integrity?", mutableListOf("Consistency", "Isolation", "Atomicity", "Durability"), 1))
        questionList.add(QModel(14, "If a transaction is rolled back, which ACID property is being upheld?", mutableListOf("Atomicity", "Isolation", "Durability", "Consistency"), 1))
        questionList.add(QModel(15, "What role does a transaction log play in ACID properties?", mutableListOf("It helps to ensure Durability by recording changes", "It increases transaction speed", "It prevents data corruption", "None of the above"), 1))
        questionList.add(QModel(16, "How do databases achieve Isolation between transactions?", mutableListOf("Using locking mechanisms or multi-version concurrency control", "By rolling back transactions", "By increasing performance", "None of the above"), 1))
        questionList.add(QModel(17, "What is a 'dirty read'?", mutableListOf("Reading uncommitted data from another transaction", "Reading data that has been committed", "Reading data from a backup", "None of the above"), 1))
        questionList.add(QModel(18, "What type of recovery ensures that only committed transactions are reflected in the database after a failure?", mutableListOf("Durability", "Consistency", "Atomicity", "Isolation"), 1))
        questionList.add(QModel(19, "What does it mean for a transaction to be 'idempotent'?", mutableListOf("It can be applied multiple times without changing the result beyond the initial application", "It is a unique transaction", "It is a failed transaction", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following statements about ACID properties is true?", mutableListOf("They ensure reliable processing of database transactions", "They allow for inconsistent data states", "They reduce the speed of database operations", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getNoSqlDatabaseQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does NoSQL stand for?", mutableListOf("Not only SQL", "No Structured Query Language", "Not SQL", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a characteristic of NoSQL databases?", mutableListOf("Schema-less data models", "High scalability", "Flexible data storage", "All of the above"), 4))
        questionList.add(QModel(3, "What type of data structure does a document-based NoSQL database typically use?", mutableListOf("Key-value pairs", "Tables", "Documents", "Graphs"), 3))
        questionList.add(QModel(4, "Which of the following is a popular NoSQL database?", mutableListOf("MySQL", "PostgreSQL", "MongoDB", "Oracle"), 3))
        questionList.add(QModel(5, "What is the primary purpose of using a key-value store?", mutableListOf("To handle complex queries", "To store unstructured data", "To retrieve data quickly by a key", "None of the above"), 3))
        questionList.add(QModel(6, "In a column-family database, how is data organized?", mutableListOf("In rows and columns", "In columns grouped into families", "In documents", "In key-value pairs"), 2))
        questionList.add(QModel(7, "Which NoSQL model is best suited for handling large amounts of unstructured data?", mutableListOf("Document model", "Column model", "Key-value model", "Graph model"), 1))
        questionList.add(QModel(8, "What is a major advantage of NoSQL databases?", mutableListOf("ACID compliance", "Horizontal scalability", "Complex joins", "Strong consistency"), 2))
        questionList.add(QModel(9, "Which NoSQL database uses a graph data model?", mutableListOf("MongoDB", "Neo4j", "Cassandra", "Redis"), 2))
        questionList.add(QModel(10, "What is CAP theorem?", mutableListOf("Consistency, Availability, Partition tolerance", "Complexity, Availability, Performance", "Consistency, Accessibility, Performance", "None of the above"), 1))
        questionList.add(QModel(11, "Which of the following is true about eventual consistency?", mutableListOf("All nodes will eventually agree on the data", "Data is always consistent across all nodes", "Data can be inconsistent for long periods", "Both A and C"), 4))
        questionList.add(QModel(12, "What is the primary storage method for a key-value database?", mutableListOf("Documents", "Key-value pairs", "Rows and columns", "Graphs"), 2))
        questionList.add(QModel(13, "Which NoSQL database is known for its high write throughput?", mutableListOf("MongoDB", "Cassandra", "Neo4j", "PostgreSQL"), 2))
        questionList.add(QModel(14, "What type of query language do most NoSQL databases use?", mutableListOf("SQL", "No standard query language", "SPARQL", "GraphQL"), 2))
        questionList.add(QModel(15, "How do NoSQL databases typically handle transactions?", mutableListOf("Using ACID properties", "Using BASE properties", "No transaction support", "None of the above"), 2))
        questionList.add(QModel(16, "What is a common use case for document-oriented NoSQL databases?", mutableListOf("Content management systems", "Transactional systems", "Real-time analytics", "Data warehousing"), 1))
        questionList.add(QModel(17, "Which of the following is NOT a type of NoSQL database?", mutableListOf("Document-oriented", "Relational", "Column-family", "Key-value"), 2))
        questionList.add(QModel(18, "What is sharding in the context of NoSQL databases?", mutableListOf("Dividing data across multiple nodes", "Replicating data across nodes", "A method for data encryption", "None of the above"), 1))
        questionList.add(QModel(19, "What type of application would benefit most from using a NoSQL database?", mutableListOf("E-commerce platform", "Social media platform", "Enterprise resource planning", "All of the above"), 4))
        questionList.add(QModel(20, "What is the role of a document in a document-oriented NoSQL database?", mutableListOf("A unit of data that contains fields and values", "A collection of tables", "A record in a relational database", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getJoinsQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a JOIN in SQL?", mutableListOf("A way to combine rows from two or more tables based on a related column", "A way to delete rows from a table", "A way to create a new table", "None of the above"), 1))
        questionList.add(QModel(2, "Which type of JOIN returns all records from the left table and matched records from the right table?", mutableListOf("LEFT JOIN", "RIGHT JOIN", "INNER JOIN", "FULL JOIN"), 1))
        questionList.add(QModel(3, "What does an INNER JOIN do?", mutableListOf("Returns only the rows that have matching values in both tables", "Returns all rows from both tables", "Returns all rows from one table regardless of match", "None of the above"), 1))
        questionList.add(QModel(4, "Which type of JOIN returns all records from both tables, regardless of whether there is a match?", mutableListOf("FULL JOIN", "LEFT JOIN", "RIGHT JOIN", "INNER JOIN"), 1))
        questionList.add(QModel(5, "What is the purpose of a RIGHT JOIN?", mutableListOf("To return all records from the right table and matched records from the left table", "To return all records from the left table", "To return only matched records from both tables", "None of the above"), 1))
        questionList.add(QModel(6, "Which keyword is used to specify the condition for a JOIN?", mutableListOf("ON", "WITH", "WHERE", "JOIN"), 1))
        questionList.add(QModel(7, "What does a CROSS JOIN do?", mutableListOf("Returns the Cartesian product of two tables", "Returns only matched records", "Returns all rows from the left table", "None of the above"), 1))
        questionList.add(QModel(8, "Which of the following is NOT a type of JOIN?", mutableListOf("LEFT JOIN", "RIGHT JOIN", "OUTER JOIN", "UPPER JOIN"), 4))
        questionList.add(QModel(9, "What is the difference between INNER JOIN and OUTER JOIN?", mutableListOf("INNER JOIN returns only matched rows, while OUTER JOIN returns all rows from one or both tables", "They are the same", "OUTER JOIN is faster than INNER JOIN", "None of the above"), 1))
        questionList.add(QModel(10, "Which JOIN type would you use to include all records from both tables even if there are no matches?", mutableListOf("FULL OUTER JOIN", "LEFT JOIN", "INNER JOIN", "CROSS JOIN"), 1))
        questionList.add(QModel(11, "When using JOINs, which operator is commonly used to specify the relationship between tables?", mutableListOf("=", "<>", "LIKE", "IN"), 1))
        questionList.add(QModel(12, "Can a JOIN be performed on multiple columns?", mutableListOf("Yes", "No", "Only in INNER JOIN", "Only in OUTER JOIN"), 1))
        questionList.add(QModel(13, "What will happen if you use a WHERE clause after a JOIN?", mutableListOf("It will filter the result set based on the specified condition", "It will create a new table", "It will not affect the result", "None of the above"), 1))
        questionList.add(QModel(14, "What does the USING clause do in a JOIN?", mutableListOf("Simplifies the JOIN condition by using a common column", "Specifies the order of the results", "Filters the results", "None of the above"), 1))
        questionList.add(QModel(15, "In SQL, what is the default type of JOIN if none is specified?", mutableListOf("INNER JOIN", "LEFT JOIN", "RIGHT JOIN", "FULL JOIN"), 1))
        questionList.add(QModel(16, "What happens if you JOIN two tables with no matching records?", mutableListOf("No rows will be returned if using INNER JOIN; rows from one or both tables will be returned for OUTER JOIN", "All rows will be returned", "Only the first table's rows will be returned", "None of the above"), 1))
        questionList.add(QModel(17, "Is it possible to JOIN more than two tables in a single SQL query?", mutableListOf("Yes", "No", "Only if they have a common column", "Only in subqueries"), 1))
        questionList.add(QModel(18, "What does the term 'self join' refer to?", mutableListOf("Joining a table to itself", "Joining two different tables", "A type of OUTER JOIN", "None of the above"), 1))
        questionList.add(QModel(19, "When is it preferable to use LEFT JOIN?", mutableListOf("When you want all records from the left table regardless of matches", "When you want only matched records", "When both tables have the same number of records", "None of the above"), 1))
        questionList.add(QModel(20, "Which type of JOIN would you use to find records that do not have matches in another table?", mutableListOf("LEFT JOIN", "RIGHT JOIN", "FULL JOIN", "INNER JOIN"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getOSIModelQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does OSI stand for?", mutableListOf("Open Systems Interconnection", "Open Standard Interface", "Operating System Interface", "None of the above"), 1))
        questionList.add(QModel(2, "How many layers are there in the OSI model?", mutableListOf("5", "6", "7", "8"), 3))
        questionList.add(QModel(3, "Which layer is responsible for establishing, maintaining, and terminating connections?", mutableListOf("Transport layer", "Session layer", "Network layer", "Data Link layer"), 2))
        questionList.add(QModel(4, "What is the primary function of the Presentation layer?", mutableListOf("Data formatting", "Routing", "Data encryption", "Session management"), 1))
        questionList.add(QModel(5, "At which layer does the TCP protocol operate?", mutableListOf("Network layer", "Transport layer", "Data Link layer", "Application layer"), 2))
        questionList.add(QModel(6, "Which layer is responsible for error detection and correction?", mutableListOf("Application layer", "Transport layer", "Data Link layer", "Network layer"), 3))
        questionList.add(QModel(7, "What does the Application layer provide?", mutableListOf("User interface", "Network services", "Routing", "Error handling"), 1))
        questionList.add(QModel(8, "Which layer manages the physical connection between devices?", mutableListOf("Network layer", "Data Link layer", "Physical layer", "Session layer"), 3))
        questionList.add(QModel(9, "What is the function of the Network layer?", mutableListOf("Data encapsulation", "Routing and forwarding", "Data formatting", "None of the above"), 2))
        questionList.add(QModel(10, "What protocol operates at the Transport layer?", mutableListOf("HTTP", "IP", "TCP", "Ethernet"), 3))
        questionList.add(QModel(11, "Which layer provides services to the user?", mutableListOf("Transport layer", "Session layer", "Application layer", "Data Link layer"), 3))
        questionList.add(QModel(12, "What is the primary role of the Data Link layer?", mutableListOf("Node-to-node data transfer", "End-to-end communication", "Session management", "Data encryption"), 1))
        questionList.add(QModel(13, "At which layer does routing occur in the OSI model?", mutableListOf("Transport layer", "Network layer", "Data Link layer", "Physical layer"), 2))
        questionList.add(QModel(14, "What is the main purpose of the OSI model?", mutableListOf("To define protocols for network communication", "To standardize network functions", "To provide a framework for network design", "All of the above"), 4))
        questionList.add(QModel(15, "Which layer is responsible for translating application data into a format suitable for transmission?", mutableListOf("Transport layer", "Session layer", "Presentation layer", "Application layer"), 3))
        questionList.add(QModel(16, "Which layer establishes, manages, and terminates sessions between applications?", mutableListOf("Session layer", "Transport layer", "Network layer", "Data Link layer"), 1))
        questionList.add(QModel(17, "Which of the following is NOT a layer of the OSI model?", mutableListOf("Application layer", "Network layer", "Internet layer", "Physical layer"), 3))
        questionList.add(QModel(18, "What does the Physical layer deal with?", mutableListOf("Data formats", "Hardware specifications", "Data transmission", "Both B and C"), 4))
        questionList.add(QModel(19, "At which layer does the SMTP protocol operate?", mutableListOf("Application layer", "Transport layer", "Network layer", "Session layer"), 1))
        questionList.add(QModel(20, "What is the main advantage of using the OSI model?", mutableListOf("Simplicity", "Modularity", "Speed", "Compatibility"), 2))

        setUpRecyclerView(questionList)
    }
    private fun getTcpIpModelQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does TCP/IP stand for?", mutableListOf("Transmission Control Protocol/Internet Protocol", "Transport Control Protocol/Internet Protocol", "Transmission Control Process/Internet Protocol", "None of the above"), 1))
        questionList.add(QModel(2, "How many layers are in the TCP/IP model?", mutableListOf("4", "5", "7", "3"), 1))
        questionList.add(QModel(3, "Which layer of the TCP/IP model is responsible for establishing a connection?", mutableListOf("Transport layer", "Internet layer", "Application layer", "Network interface layer"), 1))
        questionList.add(QModel(4, "What protocol is used for reliable data transmission in the TCP/IP model?", mutableListOf("TCP", "UDP", "IP", "HTTP"), 1))
        questionList.add(QModel(5, "Which layer of the TCP/IP model deals with logical addressing?", mutableListOf("Internet layer", "Transport layer", "Application layer", "Network interface layer"), 1))
        questionList.add(QModel(6, "What is the primary function of the Application layer in the TCP/IP model?", mutableListOf("To provide network services to applications", "To route data between devices", "To manage end-to-end communication", "None of the above"), 1))
        questionList.add(QModel(7, "What does the Internet Protocol (IP) do?", mutableListOf("Routes packets between devices on a network", "Ensures reliable transmission of data", "Provides error-checking", "None of the above"), 1))
        questionList.add(QModel(8, "Which layer of the TCP/IP model corresponds to the transport layer in the OSI model?", mutableListOf("Transport layer", "Session layer", "Network layer", "Application layer"), 1))
        questionList.add(QModel(9, "What protocol is used for connectionless communication in the TCP/IP model?", mutableListOf("UDP", "TCP", "HTTP", "FTP"), 1))
        questionList.add(QModel(10, "Which layer is responsible for the physical transmission of data over a network?", mutableListOf("Network interface layer", "Internet layer", "Transport layer", "Application layer"), 1))
        questionList.add(QModel(11, "What is the main purpose of the Transport layer in the TCP/IP model?", mutableListOf("To provide end-to-end communication and error recovery", "To handle logical addressing", "To provide services to applications", "None of the above"), 1))
        questionList.add(QModel(12, "Which protocol is used for secure data transmission over the internet?", mutableListOf("HTTPS", "FTP", "SMTP", "POP3"), 1))
        questionList.add(QModel(13, "What is a key difference between TCP and UDP?", mutableListOf("TCP is connection-oriented; UDP is connectionless", "UDP is more reliable than TCP", "TCP is faster than UDP", "None of the above"), 1))
        questionList.add(QModel(14, "Which of the following is NOT a function of the Network Interface layer?", mutableListOf("Framing", "Physical addressing", "Routing", "Error detection"), 3))
        questionList.add(QModel(15, "What is the primary role of the Internet layer?", mutableListOf("To route packets across networks", "To provide error recovery", "To establish connections between hosts", "None of the above"), 1))
        questionList.add(QModel(16, "In the TCP/IP model, what layer does the term 'packet' refer to?", mutableListOf("Internet layer", "Transport layer", "Network interface layer", "Application layer"), 1))
        questionList.add(QModel(17, "What type of addressing is used at the Internet layer?", mutableListOf("Logical addressing (IP addresses)", "Physical addressing (MAC addresses)", "Port numbers", "None of the above"), 1))
        questionList.add(QModel(18, "Which layer of the TCP/IP model corresponds to the Data Link layer in the OSI model?", mutableListOf("Network interface layer", "Transport layer", "Internet layer", "Application layer"), 1))
        questionList.add(QModel(19, "What does a router do in a TCP/IP network?", mutableListOf("Routes packets between different networks", "Provides end-to-end communication", "Connects devices on the same network", "None of the above"), 1))
        questionList.add(QModel(20, "Which protocol is commonly used for email transmission in the TCP/IP model?", mutableListOf("SMTP", "HTTP", "FTP", "POP3"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getRoutingAlgorithmQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a routing algorithm?", mutableListOf("A method for determining the best path for data transmission", "A technique for data encryption", "A method for error detection", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a type of routing algorithm?", mutableListOf("Static routing", "Dynamic routing", "Distance-vector routing", "All of the above"), 4))
        questionList.add(QModel(3, "What does a distance-vector routing algorithm use to determine the best path?", mutableListOf("The total number of hops", "The cost of transmission", "Link state information", "None of the above"), 1))
        questionList.add(QModel(4, "Which routing algorithm updates routing tables based on network topology changes?", mutableListOf("Static routing", "Distance-vector routing", "Link state routing", "None of the above"), 3))
        questionList.add(QModel(5, "What is the main disadvantage of distance-vector routing?", mutableListOf("Slow convergence", "Increased complexity", "Requires more bandwidth", "None of the above"), 1))
        questionList.add(QModel(6, "Which protocol uses the distance-vector routing algorithm?", mutableListOf("RIP", "OSPF", "BGP", "EIGRP"), 1))
        questionList.add(QModel(7, "What is the purpose of the Link State Routing protocol?", mutableListOf("To share the complete routing table", "To find the shortest path using Dijkstra's algorithm", "To determine the best path using hop count", "None of the above"), 2))
        questionList.add(QModel(8, "In which routing algorithm does each router maintain a complete map of the network?", mutableListOf("Distance-vector", "Link state", "Static", "Dynamic"), 2))
        questionList.add(QModel(9, "Which of the following algorithms is known for its fast convergence?", mutableListOf("Distance-vector routing", "Link state routing", "RIP", "BGP"), 2))
        questionList.add(QModel(10, "What does the term 'convergence' refer to in routing?", mutableListOf("All routers having the same routing information", "The speed at which routers update their routing tables", "The ability to find multiple paths", "None of the above"), 1))
        questionList.add(QModel(11, "Which routing protocol is classified as a path-vector protocol?", mutableListOf("OSPF", "RIP", "BGP", "EIGRP"), 3))
        questionList.add(QModel(12, "What is the purpose of the 'hello' packets in OSPF?", mutableListOf("To establish and maintain neighbor relationships", "To send routing updates", "To advertise the network", "None of the above"), 1))
        questionList.add(QModel(13, "Which routing algorithm uses the Bellman-Ford algorithm?", mutableListOf("Distance-vector routing", "Link state routing", "Static routing", "None of the above"), 1))
        questionList.add(QModel(14, "What type of routing table is used in static routing?", mutableListOf("Dynamic", "User-defined", "Automatically generated", "None of the above"), 2))
        questionList.add(QModel(15, "Which of the following is a characteristic of dynamic routing?", mutableListOf("Requires manual configuration", "Automatically adjusts to network changes", "Less overhead than static routing", "None of the above"), 2))
        questionList.add(QModel(16, "What is the role of the routing metric?", mutableListOf("To determine the best path", "To encode the routing protocol", "To identify network segments", "None of the above"), 1))
        questionList.add(QModel(17, "Which protocol uses the OSPF routing algorithm?", mutableListOf("RIP", "BGP", "IS-IS", "EIGRP"), 3))
        questionList.add(QModel(18, "What is the main difference between static and dynamic routing?", mutableListOf("Static routing uses predefined routes, while dynamic routing adapts to changes", "Dynamic routing is less secure than static routing", "Static routing is faster than dynamic routing", "None of the above"), 1))
        questionList.add(QModel(19, "What does the term 'routing loop' refer to?", mutableListOf("A situation where packets are continuously routed in a cycle", "The time it takes for a packet to reach its destination", "The distance between routers", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following is NOT a factor that affects routing decisions?", mutableListOf("Network topology", "Traffic load", "Packet size", "Routing protocol"), 3))

        setUpRecyclerView(questionList)
    }
    private fun getIpAddressingQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does IP stand for?", mutableListOf("Internet Protocol", "Interconnected Protocol", "Internal Protocol", "Internet Package"), 1))
        questionList.add(QModel(2, "What are the two main versions of IP?", mutableListOf("IPv4 and IPv6", "IPv1 and IPv2", "IPv3 and IPv5", "IPv4 and IPv7"), 1))
        questionList.add(QModel(3, "How many bits are used in an IPv4 address?", mutableListOf("32 bits", "64 bits", "128 bits", "16 bits"), 1))
        questionList.add(QModel(4, "What is the range of valid IPv4 addresses?", mutableListOf("0.0.0.0 to 255.255.255.255", "1.0.0.0 to 255.255.255.255", "0.0.0.0 to 128.255.255.255", "1.0.0.0 to 128.0.0.0"), 1))
        questionList.add(QModel(5, "What is a subnet mask?", mutableListOf("A mask used to divide an IP address into a network and host portion", "A type of IP address", "A protocol for routing packets", "None of the above"), 1))
        questionList.add(QModel(6, "What does CIDR stand for?", mutableListOf("Classless Inter-Domain Routing", "Classful Inter-Domain Routing", "Classless Internet Domain Routing", "None of the above"), 1))
        questionList.add(QModel(7, "What is the purpose of NAT?", mutableListOf("To translate private IP addresses to a public IP address", "To assign IP addresses to devices", "To block unwanted traffic", "None of the above"), 1))
        questionList.add(QModel(8, "Which of the following is a valid private IPv4 address?", mutableListOf("192.168.1.1", "172.15.0.1", "10.0.0.1", "Both A and C"), 4))
        questionList.add(QModel(9, "What is the loopback address in IPv4?", mutableListOf("127.0.0.1", "0.0.0.0", "255.255.255.255", "192.168.1.1"), 1))
        questionList.add(QModel(10, "What is an IPv6 address composed of?", mutableListOf("8 groups of 4 hexadecimal digits", "4 groups of 8 binary digits", "32 decimal numbers", "4 groups of 16 hexadecimal digits"), 1))
        questionList.add(QModel(11, "What is the primary benefit of IPv6 over IPv4?", mutableListOf("Larger address space", "Faster speeds", "More security features", "Simpler configuration"), 1))
        questionList.add(QModel(12, "What is a broadcast address?", mutableListOf("An address used to send data to all devices on a network", "An address for a single device", "An address used for routing", "None of the above"), 1))
        questionList.add(QModel(13, "Which of the following is a characteristic of IPv4?", mutableListOf("Supports a maximum of about 4.3 billion addresses", "Uses 128-bit addressing", "Allows for hierarchical addressing", "None of the above"), 1))
        questionList.add(QModel(14, "What is an example of an IP address?", mutableListOf("192.168.1.1", "255.255.255.255", "172.16.0.1", "All of the above"), 4))
        questionList.add(QModel(15, "In IPv4, what does a Class A address represent?", mutableListOf("Large networks", "Medium networks", "Small networks", "None of the above"), 1))
        questionList.add(QModel(16, "How is an IPv6 address usually represented?", mutableListOf("Hexadecimal notation", "Decimal notation", "Binary notation", "Octal notation"), 1))
        questionList.add(QModel(17, "What does the '::' notation mean in IPv6?", mutableListOf("A shorthand for consecutive zero groups", "A reserved address", "A multicast address", "None of the above"), 1))
        questionList.add(QModel(18, "What is the main purpose of the Address Resolution Protocol (ARP)?", mutableListOf("To map IP addresses to MAC addresses", "To assign IP addresses", "To manage routing", "None of the above"), 1))
        questionList.add(QModel(19, "What is the significance of the first octet in a Class B IP address?", mutableListOf("It defines the network portion", "It defines the host portion", "It indicates the address type", "None of the above"), 1))
        questionList.add(QModel(20, "What protocol is used to assign IP addresses dynamically?", mutableListOf("DHCP", "ARP", "NAT", "ICMP"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getNetworkLayersQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "How many layers are there in the OSI model?", mutableListOf("5", "6", "7", "8"), 3))
        questionList.add(QModel(2, "Which layer of the OSI model is responsible for end-to-end communication?", mutableListOf("Transport layer", "Network layer", "Session layer", "Application layer"), 1))
        questionList.add(QModel(3, "What is the primary function of the Data Link layer?", mutableListOf("Routing packets", "Framing and error detection", "Data encryption", "Session management"), 2))
        questionList.add(QModel(4, "Which layer of the OSI model deals with IP addressing?", mutableListOf("Network layer", "Transport layer", "Data Link layer", "Application layer"), 1))
        questionList.add(QModel(5, "Which layer is responsible for establishing, managing, and terminating sessions?", mutableListOf("Transport layer", "Network layer", "Session layer", "Application layer"), 3))
        questionList.add(QModel(6, "What is the purpose of the Physical layer?", mutableListOf("Data encryption", "Signal transmission over physical media", "Routing and switching", "Error correction"), 2))
        questionList.add(QModel(7, "At which layer of the OSI model does TCP operate?", mutableListOf("Application layer", "Transport layer", "Network layer", "Data Link layer"), 2))
        questionList.add(QModel(8, "What type of addressing is used at the Data Link layer?", mutableListOf("IP addressing", "MAC addressing", "Port addressing", "None of the above"), 2))
        questionList.add(QModel(9, "Which layer provides services for data compression and encryption?", mutableListOf("Application layer", "Presentation layer", "Session layer", "Transport layer"), 2))
        questionList.add(QModel(10, "What is the main responsibility of the Application layer?", mutableListOf("Data formatting", "User interface and application services", "Session management", "Routing packets"), 2))
        questionList.add(QModel(11, "Which OSI layer is responsible for flow control and error recovery?", mutableListOf("Transport layer", "Network layer", "Data Link layer", "Physical layer"), 1))
        questionList.add(QModel(12, "What is the function of the Network layer?", mutableListOf("Data delivery between hosts", "Routing and forwarding packets", "Error detection", "None of the above"), 2))
        questionList.add(QModel(13, "Which layer is concerned with the syntax and semantics of the information exchanged?", mutableListOf("Data Link layer", "Session layer", "Presentation layer", "Transport layer"), 3))
        questionList.add(QModel(14, "Which layer does the Internet Protocol (IP) operate at?", mutableListOf("Transport layer", "Application layer", "Network layer", "Data Link layer"), 3))
        questionList.add(QModel(15, "What is the main function of the Session layer?", mutableListOf("Data encryption", "Maintaining sessions and managing connections", "Routing and forwarding", "Error detection"), 2))
        questionList.add(QModel(16, "What kind of protocol is HTTP?", mutableListOf("Transport layer protocol", "Network layer protocol", "Application layer protocol", "Data Link layer protocol"), 3))
        questionList.add(QModel(17, "Which OSI layer is responsible for segmenting data?", mutableListOf("Application layer", "Transport layer", "Network layer", "Data Link layer"), 2))
        questionList.add(QModel(18, "What type of communication does the OSI model's Transport layer facilitate?", mutableListOf("Unicast only", "Multicast only", "Broadcast only", "All types of communication"), 4))
        questionList.add(QModel(19, "Which protocol operates at the Transport layer?", mutableListOf("UDP", "IP", "Ethernet", "None of the above"), 1))
        questionList.add(QModel(20, "What is the main role of the Data Link layer in relation to the Physical layer?", mutableListOf("Data routing", "Error correction and framing", "Data encryption", "None of the above"), 2))

        setUpRecyclerView(questionList)
    }
    private fun getFunctionalProgrammingQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a pure function?", mutableListOf("A function that has no side effects", "A function that always returns the same output for the same input", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(2, "Which of the following is a characteristic of functional programming?", mutableListOf("Mutable data", "First-class functions", "Imperative programming style", "None of the above"), 2))
        questionList.add(QModel(3, "What is a higher-order function?", mutableListOf("A function that takes another function as an argument", "A function that returns another function", "Both A and B", "None of the above"), 3))
        questionList.add(QModel(4, "What does 'first-class citizen' mean in the context of functions?", mutableListOf("Functions can be passed as arguments", "Functions can be returned from other functions", "Functions can be assigned to variables", "All of the above"), 4))
        questionList.add(QModel(5, "Which of the following is NOT a functional programming language?", mutableListOf("Haskell", "Scala", "Java", "Clojure"), 3))
        questionList.add(QModel(6, "What is immutability?", mutableListOf("The inability to change an object's state", "The ability to change an object's state", "The ability to pass functions as arguments", "None of the above"), 1))
        questionList.add(QModel(7, "Which of the following is a common feature of functional programming?", mutableListOf("Loops", "Recursion", "Mutable state", "None of the above"), 2))
        questionList.add(QModel(8, "What is a lambda expression?", mutableListOf("An anonymous function", "A named function", "A recursive function", "None of the above"), 1))
        questionList.add(QModel(9, "What is function composition?", mutableListOf("Combining two or more functions to create a new function", "Calling a function within another function", "None of the above", "All of the above"), 1))
        questionList.add(QModel(10, "Which of the following is a benefit of functional programming?", mutableListOf("Easier to reason about code", "Improved performance", "Less code", "None of the above"), 1))
        questionList.add(QModel(11, "What is a closure?", mutableListOf("A function that captures the lexical scope", "A function that cannot access outer variables", "A function that is called recursively", "None of the above"), 1))
        questionList.add(QModel(12, "What does 'referential transparency' mean?", mutableListOf("Functions can be replaced with their output", "Functions cannot be tested", "Functions can have side effects", "None of the above"), 1))
        questionList.add(QModel(13, "Which of the following is an example of a functional programming concept?", mutableListOf("Map", "Filter", "Reduce", "All of the above"), 4))
        questionList.add(QModel(14, "In functional programming, what is lazy evaluation?", mutableListOf("Evaluation of expressions only when needed", "Immediate evaluation of expressions", "None of the above", "Both A and B"), 1))
        questionList.add(QModel(15, "What is tail recursion?", mutableListOf("A recursive function where the recursive call is the last operation", "A recursive function that calls itself multiple times", "None of the above", "Both A and B"), 1))
        questionList.add(QModel(16, "Which keyword is commonly used to define a function in Kotlin?", mutableListOf("fun", "def", "function", "method"), 1))
        questionList.add(QModel(17, "What is the purpose of the `map` function?", mutableListOf("To transform each element in a collection", "To filter elements in a collection", "To reduce a collection to a single value", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following is a functional programming principle?", mutableListOf("State and mutable data", "Functions as first-class citizens", "Side effects", "None of the above"), 2))
        questionList.add(QModel(19, "What does the `filter` function do?", mutableListOf("Selects elements from a collection based on a condition", "Transforms each element in a collection", "Combines elements in a collection", "None of the above"), 1))
        questionList.add(QModel(20, "What is recursion in functional programming?", mutableListOf("A function calling itself", "A loop that iterates through elements", "None of the above", "Both A and B"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getOopQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does OOP stand for?", mutableListOf("Object-Oriented Programming", "Object-Oriented Procedure", "Operational Object Programming", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is NOT a core concept of OOP?", mutableListOf("Inheritance", "Polymorphism", "Encapsulation", "Compilation"), 4))
        questionList.add(QModel(3, "What is encapsulation?", mutableListOf("Hiding the internal state of an object", "The ability to take on many forms", "The process of creating a new class from an existing class", "None of the above"), 1))
        questionList.add(QModel(4, "What is inheritance?", mutableListOf("The process by which one class can inherit properties and methods from another class", "Hiding the implementation details of a class", "The ability of different classes to be treated as instances of the same class", "None of the above"), 1))
        questionList.add(QModel(5, "What is polymorphism?", mutableListOf("The ability of different classes to be treated as instances of the same class", "The process of hiding data", "The ability to create multiple classes from a single class", "None of the above"), 1))
        questionList.add(QModel(6, "What is a class?", mutableListOf("A blueprint for creating objects", "An instance of an object", "A data type", "None of the above"), 1))
        questionList.add(QModel(7, "What is an object?", mutableListOf("An instance of a class", "A blueprint for creating classes", "A method of a class", "None of the above"), 1))
        questionList.add(QModel(8, "What does the term 'method' refer to in OOP?", mutableListOf("A function defined in a class", "A class variable", "An instance of a class", "None of the above"), 1))
        questionList.add(QModel(9, "Which of the following is an example of a programming language that supports OOP?", mutableListOf("C++", "Java", "Python", "All of the above"), 4))
        questionList.add(QModel(10, "What is the main purpose of an abstract class?", mutableListOf("To provide a base for other classes", "To create instances", "To hide the implementation details", "None of the above"), 1))
        questionList.add(QModel(11, "What is a constructor?", mutableListOf("A special method called when an object is created", "A method to initialize class variables", "A method to delete objects", "None of the above"), 1))
        questionList.add(QModel(12, "What is method overloading?", mutableListOf("Defining multiple methods with the same name but different parameters", "Defining a method in a subclass with the same name as in its superclass", "A way to restrict access to methods", "None of the above"), 1))
        questionList.add(QModel(13, "What is method overriding?", mutableListOf("Defining a method in a subclass with the same name as in its superclass", "Creating multiple methods with the same name", "Hiding a method from subclasses", "None of the above"), 1))
        questionList.add(QModel(14, "What is an interface?", mutableListOf("A contract that defines a set of methods that implementing classes must provide", "A type of class", "A method to encapsulate data", "None of the above"), 1))
        questionList.add(QModel(15, "What does the 'this' keyword refer to in OOP?", mutableListOf("The current object", "The superclass", "A static method", "None of the above"), 1))
        questionList.add(QModel(16, "What is a static method?", mutableListOf("A method that belongs to the class rather than instances of the class", "A method that cannot be overridden", "A method that can only be called from an instance", "None of the above"), 1))
        questionList.add(QModel(17, "What is the difference between a class and an object?", mutableListOf("A class is a blueprint; an object is an instance", "An object is a blueprint; a class is an instance", "Both are the same", "None of the above"), 1))
        questionList.add(QModel(18, "What is the main goal of OOP?", mutableListOf("To improve code reusability and maintainability", "To create faster programs", "To eliminate bugs", "None of the above"), 1))
        questionList.add(QModel(19, "What is data abstraction?", mutableListOf("Hiding the complex reality while exposing only the necessary parts", "A way to create subclasses", "The process of defining a method", "None of the above"), 1))
        questionList.add(QModel(20, "What is a destructor?", mutableListOf("A method called when an object is destroyed", "A method to create objects", "A type of constructor", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getImperativeVsDeclarativeQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What does imperative programming focus on?", mutableListOf("Describing how to achieve a result", "Describing what the result should be", "Declaring data types", "None of the above"), 1))
        questionList.add(QModel(2, "What does declarative programming focus on?", mutableListOf("Describing what the result should be", "Describing how to achieve a result", "Defining control structures", "None of the above"), 1))
        questionList.add(QModel(3, "Which of the following is an example of an imperative programming language?", mutableListOf("C", "SQL", "Haskell", "HTML"), 1))
        questionList.add(QModel(4, "Which of the following is an example of a declarative programming language?", mutableListOf("Python", "Java", "SQL", "C++"), 3))
        questionList.add(QModel(5, "In which style of programming are commands issued sequentially?", mutableListOf("Imperative programming", "Declarative programming", "Both", "None of the above"), 1))
        questionList.add(QModel(6, "What is a characteristic of imperative programming?", mutableListOf("Focuses on control flow", "Focuses on data flow", "Uses expressions to declare results", "None of the above"), 1))
        questionList.add(QModel(7, "What is a characteristic of declarative programming?", mutableListOf("Focuses on what to do rather than how to do it", "Focuses on step-by-step instructions", "Involves mutable state", "None of the above"), 1))
        questionList.add(QModel(8, "Which programming paradigm often leads to more concise code?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 2))
        questionList.add(QModel(9, "In which programming style is side-effect management crucial?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 1))
        questionList.add(QModel(10, "Which paradigm is often associated with functional programming?", mutableListOf("Imperative programming", "Declarative programming", "Object-oriented programming", "Procedural programming"), 2))
        questionList.add(QModel(11, "Which programming style allows for easier parallelization?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 2))
        questionList.add(QModel(12, "Which paradigm generally requires the programmer to manage state?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 1))
        questionList.add(QModel(13, "Which of the following statements best describes imperative programming?", mutableListOf("It uses explicit sequences of commands", "It describes relationships between data", "It focuses on the outcome", "None of the above"), 1))
        questionList.add(QModel(14, "In which style of programming is the use of expressions more prevalent?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 2))
        questionList.add(QModel(15, "Which programming paradigm is often easier for beginners to understand?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 1))
        questionList.add(QModel(16, "Which programming style can lead to more efficient code optimization?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 2))
        questionList.add(QModel(17, "In what style do programmers describe a sequence of steps to be performed?", mutableListOf("Declarative programming", "Imperative programming", "Functional programming", "Logic programming"), 2))
        questionList.add(QModel(18, "Which programming style typically results in more readable code when managing complex logic?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 2))
        questionList.add(QModel(19, "Which paradigm may result in code that is harder to debug due to side effects?", mutableListOf("Imperative programming", "Declarative programming", "Both", "Neither"), 1))
        questionList.add(QModel(20, "In which programming style are variable declarations common?", mutableListOf("Declarative programming", "Imperative programming", "Both", "Neither"), 2))

        setUpRecyclerView(questionList)
    }
    private fun getEventDrivenProgrammingQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is event-driven programming?", mutableListOf("A programming paradigm where the flow of the program is determined by events", "A programming paradigm focused on sequential execution", "A programming style that emphasizes data manipulation", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is an example of an event?", mutableListOf("User clicks a button", "Data is fetched from a server", "Timer expires", "All of the above"), 4))
        questionList.add(QModel(3, "What is an event handler?", mutableListOf("A function that responds to an event", "A function that creates events", "A function that logs events", "None of the above"), 1))
        questionList.add(QModel(4, "In event-driven programming, what is a listener?", mutableListOf("A function that waits for events to occur", "A function that creates events", "A function that executes events", "None of the above"), 1))
        questionList.add(QModel(5, "What is a callback function?", mutableListOf("A function passed as an argument to another function", "A function that is called automatically", "A function that handles errors", "None of the above"), 1))
        questionList.add(QModel(6, "Which of the following is NOT a characteristic of event-driven programming?", mutableListOf("Asynchronous execution", "Blocking execution", "Decoupling of components", "Event dispatching"), 2))
        questionList.add(QModel(7, "In which scenario is event-driven programming commonly used?", mutableListOf("Web development", "Game development", "User interface applications", "All of the above"), 4))
        questionList.add(QModel(8, "What is an event loop?", mutableListOf("A loop that continuously checks for events to handle", "A loop that iterates over elements", "A loop that processes data", "None of the above"), 1))
        questionList.add(QModel(9, "What is the purpose of an event queue?", mutableListOf("To store events until they are processed", "To handle function calls", "To store variables", "None of the above"), 1))
        questionList.add(QModel(10, "Which programming languages commonly support event-driven programming?", mutableListOf("JavaScript", "Python", "Java", "All of the above"), 4))
        questionList.add(QModel(11, "What is a synchronous event?", mutableListOf("An event that occurs and must be processed immediately", "An event that can be processed later", "An event that happens in the background", "None of the above"), 1))
        questionList.add(QModel(12, "Which of the following can trigger an event?", mutableListOf("User input", "System changes", "Timers", "All of the above"), 4))
        questionList.add(QModel(13, "What does the term 'event propagation' refer to?", mutableListOf("The way events are transmitted from one object to another", "The way functions are called", "The way data is manipulated", "None of the above"), 1))
        questionList.add(QModel(14, "What is event delegation?", mutableListOf("A technique to handle events at a higher level in the DOM", "A method of passing events to different functions", "A way to create new events", "None of the above"), 1))
        questionList.add(QModel(15, "In which type of application is event-driven programming particularly beneficial?", mutableListOf("Command-line applications", "Graphical user interface applications", "Batch processing applications", "None of the above"), 2))
        questionList.add(QModel(16, "Which of the following is an event-driven architecture?", mutableListOf("Model-View-Controller (MVC)", "Microservices", "Publisher-Subscriber", "All of the above"), 4))
        questionList.add(QModel(17, "What is a custom event?", mutableListOf("An event defined by the developer for specific functionality", "An event that is predefined in a framework", "An event that occurs at regular intervals", "None of the above"), 1))
        questionList.add(QModel(18, "What is the main advantage of using event-driven programming?", mutableListOf("Increased code efficiency", "Better user experience", "Simplicity in handling asynchronous tasks", "All of the above"), 4))
        questionList.add(QModel(19, "What is the role of a dispatcher in event-driven programming?", mutableListOf("To distribute events to appropriate handlers", "To handle user inputs", "To log events", "None of the above"), 1))
        questionList.add(QModel(20, "Which method is used to add an event listener in JavaScript?", mutableListOf("addEventListener()", "onEvent()", "attachEvent()", "bindEvent()"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getGitBasicsQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is Git?", mutableListOf("A version control system", "A programming language", "A text editor", "A web browser"), 1))
        questionList.add(QModel(2, "Which command is used to create a new Git repository?", mutableListOf("git init", "git create", "git start", "git new"), 1))
        questionList.add(QModel(3, "How do you check the status of your Git repository?", mutableListOf("git status", "git check", "git current", "git info"), 1))
        questionList.add(QModel(4, "Which command is used to stage changes for the next commit?", mutableListOf("git stage", "git add", "git commit", "git push"), 2))
        questionList.add(QModel(5, "What does 'git commit' do?", mutableListOf("Records changes to the repository", "Displays the commit history", "Reverts changes", "None of the above"), 1))
        questionList.add(QModel(6, "What is a branch in Git?", mutableListOf("A separate line of development", "A version of a file", "A command to merge changes", "None of the above"), 1))
        questionList.add(QModel(7, "How do you create a new branch in Git?", mutableListOf("git branch <branch-name>", "git new-branch <branch-name>", "git create-branch <branch-name>", "git checkout -b <branch-name>"), 1))
        questionList.add(QModel(8, "What is the purpose of 'git merge'?", mutableListOf("To combine changes from different branches", "To remove a branch", "To update the repository", "None of the above"), 1))
        questionList.add(QModel(9, "How do you view the commit history in Git?", mutableListOf("git log", "git history", "git commits", "git show"), 1))
        questionList.add(QModel(10, "What command is used to push local changes to a remote repository?", mutableListOf("git upload", "git push", "git send", "git commit"), 2))
        questionList.add(QModel(11, "What is a remote repository?", mutableListOf("A version of the repository stored on a server", "A backup of your local repository", "A local branch", "None of the above"), 1))
        questionList.add(QModel(12, "What command do you use to fetch changes from a remote repository?", mutableListOf("git fetch", "git pull", "git update", "git sync"), 1))
        questionList.add(QModel(13, "What does 'git clone' do?", mutableListOf("Creates a copy of a remote repository locally", "Merges branches", "Creates a new branch", "Commits changes"), 1))
        questionList.add(QModel(14, "Which command can you use to discard changes in your working directory?", mutableListOf("git reset", "git clean", "git checkout", "All of the above"), 4))
        questionList.add(QModel(15, "What is a commit message?", mutableListOf("A description of changes made in a commit", "A comment on the repository", "A summary of the branch", "None of the above"), 1))
        questionList.add(QModel(16, "What is the purpose of 'git rebase'?", mutableListOf("To apply commits from one branch onto another", "To merge branches", "To create a new branch", "None of the above"), 1))
        questionList.add(QModel(17, "How do you remove a branch in Git?", mutableListOf("git branch -d <branch-name>", "git remove <branch-name>", "git delete <branch-name>", "git branch rm <branch-name>"), 1))
        questionList.add(QModel(18, "What is a tag in Git?", mutableListOf("A marker for a specific point in the commit history", "A type of branch", "A command to update the repository", "None of the above"), 1))
        questionList.add(QModel(19, "Which command do you use to rename a branch?", mutableListOf("git rename <old-name> <new-name>", "git branch -m <old-name> <new-name>", "git change <old-name> <new-name>", "git branch rename <old-name> <new-name>"), 2))
        questionList.add(QModel(20, "What does 'git stash' do?", mutableListOf("Temporarily saves changes in your working directory", "Commits changes", "Pushes changes to a remote", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getBranchesQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a branch in programming?", mutableListOf("A point in the code where the control flow splits", "A separate copy of the code repository", "A data structure for organizing data", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is an example of a branching statement?", mutableListOf("if statement", "for loop", "while loop", "function call"), 1))
        questionList.add(QModel(3, "What does an if statement do?", mutableListOf("Executes a block of code if a condition is true", "Executes a block of code repeatedly", "Skips a block of code", "None of the above"), 1))
        questionList.add(QModel(4, "What is the purpose of an else statement?", mutableListOf("To provide an alternative block of code if the if condition is false", "To repeat a block of code", "To create a function", "None of the above"), 1))
        questionList.add(QModel(5, "What does a switch statement do?", mutableListOf("Selects one of many code blocks to execute", "Repeats a block of code", "Evaluates a condition", "None of the above"), 1))
        questionList.add(QModel(6, "In which scenario would you use a switch statement?", mutableListOf("When you have multiple conditions to check", "When you want to perform a loop", "When handling errors", "None of the above"), 1))
        questionList.add(QModel(7, "What is a ternary operator?", mutableListOf("A shorthand way to write an if-else statement", "A type of loop", "A data structure", "None of the above"), 1))
        questionList.add(QModel(8, "Which statement is used to exit a loop in programming?", mutableListOf("break", "continue", "return", "exit"), 1))
        questionList.add(QModel(9, "What is the purpose of a return statement?", mutableListOf("To exit a function and optionally return a value", "To create a loop", "To define a function", "None of the above"), 1))
        questionList.add(QModel(10, "Which of the following statements is used to skip an iteration in a loop?", mutableListOf("continue", "break", "return", "exit"), 1))
        questionList.add(QModel(11, "What is a nested if statement?", mutableListOf("An if statement inside another if statement", "An if statement inside a loop", "An if statement that checks multiple conditions", "None of the above"), 1))
        questionList.add(QModel(12, "Which logical operators are commonly used in branching statements?", mutableListOf("AND, OR, NOT", "ADD, SUBTRACT, MULTIPLY", "INCREMENT, DECREMENT", "None of the above"), 1))
        questionList.add(QModel(13, "What is the primary benefit of using branching statements?", mutableListOf("Control flow based on conditions", "Improved performance", "Reduced code length", "None of the above"), 1))
        questionList.add(QModel(14, "What happens if no conditions are met in an if-else statement?", mutableListOf("The program continues without executing any branch", "The program throws an error", "The program enters an infinite loop", "None of the above"), 1))
        questionList.add(QModel(15, "What is an infinite loop?", mutableListOf("A loop that never terminates", "A loop that runs a fixed number of times", "A loop that executes conditionally", "None of the above"), 1))
        questionList.add(QModel(16, "What is a decision tree?", mutableListOf("A model that represents branching decisions", "A type of data structure", "A looping mechanism", "None of the above"), 1))
        questionList.add(QModel(17, "How can you handle exceptions in programming?", mutableListOf("Using try-catch blocks", "Using if statements", "Using loops", "None of the above"), 1))
        questionList.add(QModel(18, "What is a guard clause?", mutableListOf("A way to exit a function early if a condition is met", "A way to define branches", "A looping construct", "None of the above"), 1))
        questionList.add(QModel(19, "Which programming language uses indentation to define blocks of code?", mutableListOf("Python", "C++", "Java", "JavaScript"), 1))
        questionList.add(QModel(20, "What is the function of logical operators in branching statements?", mutableListOf("To combine multiple conditions", "To perform mathematical operations", "To create loops", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getMergeConflictQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is a merge conflict?", mutableListOf("When Git cannot automatically resolve differences between branches", "When a branch is deleted", "When a commit fails", "None of the above"), 1))
        questionList.add(QModel(2, "Which command typically triggers a merge conflict?", mutableListOf("git merge", "git pull", "git push", "git clone"), 1))
        questionList.add(QModel(3, "How can you resolve a merge conflict?", mutableListOf("By manually editing the conflicting files", "By using git merge", "By creating a new branch", "None of the above"), 1))
        questionList.add(QModel(4, "What happens to the code when a merge conflict occurs?", mutableListOf("Git marks the conflicting files for manual resolution", "Code is lost", "All changes are reverted", "None of the above"), 1))
        questionList.add(QModel(5, "How can you view the files that have merge conflicts?", mutableListOf("git status", "git conflict", "git log", "git diff"), 1))
        questionList.add(QModel(6, "What symbols indicate conflict markers in a file?", mutableListOf("<<<<<<<, =======, >>>>>>>", "<<<, ===, >>>", "||, &&, ++", "None of the above"), 1))
        questionList.add(QModel(7, "Which command can be used to abort a merge process?", mutableListOf("git merge --abort", "git cancel", "git reset", "git stop"), 1))
        questionList.add(QModel(8, "What is the best practice after resolving a merge conflict?", mutableListOf("Run tests to ensure functionality is intact", "Immediately push the changes", "Delete the conflicting files", "None of the above"), 1))
        questionList.add(QModel(9, "Can you have multiple merge conflicts at the same time?", mutableListOf("Yes", "No", "Only in large projects", "Only if you are working with multiple branches"), 1))
        questionList.add(QModel(10, "What is the consequence of ignoring merge conflicts?", mutableListOf("Inconsistent code and potential bugs", "Nothing happens", "Code is automatically resolved", "None of the above"), 1))
        questionList.add(QModel(11, "What command allows you to view changes between commits that caused a conflict?", mutableListOf("git diff", "git status", "git log", "git merge"), 1))
        questionList.add(QModel(12, "What should you do if you're unsure how to resolve a merge conflict?", mutableListOf("Seek help from a teammate", "Commit and push anyway", "Ignore the conflict", "None of the above"), 1))
        questionList.add(QModel(13, "Which file type is most likely to cause merge conflicts?", mutableListOf("Source code files", "Binary files", "Configuration files", "Documentation files"), 1))
        questionList.add(QModel(14, "What is a common method to avoid merge conflicts?", mutableListOf("Frequent pulling and pushing changes", "Always working on the master branch", "Using only one branch", "None of the above"), 1))
        questionList.add(QModel(15, "After resolving conflicts, which command is used to mark the files as resolved?", mutableListOf("git add <file>", "git resolve <file>", "git commit <file>", "git mark <file>"), 1))
        questionList.add(QModel(16, "What is a fast-forward merge?", mutableListOf("A merge that does not create a new commit", "A merge with conflicts", "A merge that creates multiple commits", "None of the above"), 1))
        questionList.add(QModel(17, "What can you use to visualize merge conflicts more easily?", mutableListOf("Merge tools", "Text editors", "Command line", "None of the above"), 1))
        questionList.add(QModel(18, "What command do you use to continue the merge after resolving conflicts?", mutableListOf("git commit", "git continue", "git resume", "git merge --continue"), 1))
        questionList.add(QModel(19, "What is the first step you should take when encountering a merge conflict?", mutableListOf("Identify conflicting files", "Push your changes", "Start a new branch", "Discard all changes"), 1))
        questionList.add(QModel(20, "Which tool can help automate the merge conflict resolution process?", mutableListOf("Merge tools", "Commit tools", "Version control systems", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getRebasingQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is rebasing in Git?", mutableListOf("Moving or combining a sequence of commits to a new base commit", "Creating a new branch from an existing one", "Merging two branches together", "None of the above"), 1))
        questionList.add(QModel(2, "What is the main purpose of rebasing?", mutableListOf("To maintain a clean project history", "To resolve merge conflicts", "To create new branches", "None of the above"), 1))
        questionList.add(QModel(3, "Which command is used to start a rebase in Git?", mutableListOf("git rebase", "git merge", "git branch", "git commit"), 1))
        questionList.add(QModel(4, "What happens to the commit history after rebasing?", mutableListOf("It gets rewritten", "It remains the same", "All commits are deleted", "None of the above"), 1))
        questionList.add(QModel(5, "How does rebasing differ from merging?", mutableListOf("Rebasing rewrites history, while merging preserves it", "Rebasing creates a new commit, while merging doesn't", "Rebasing is faster than merging", "None of the above"), 1))
        questionList.add(QModel(6, "What is a common scenario where rebasing is useful?", mutableListOf("Updating a feature branch with changes from the main branch", "Deleting a branch", "Creating a new commit", "None of the above"), 1))
        questionList.add(QModel(7, "What should you avoid doing when rebasing?", mutableListOf("Rebasing commits that have been shared with others", "Creating a new branch", "Resolving conflicts", "None of the above"), 1))
        questionList.add(QModel(8, "What command would you use to rebase your current branch onto another branch?", mutableListOf("git rebase <branch-name>", "git merge <branch-name>", "git checkout <branch-name>", "git commit <branch-name>"), 1))
        questionList.add(QModel(9, "What is a fast-forward rebase?", mutableListOf("A rebase that moves the branch pointer forward without creating new commits", "A rebase that creates multiple new commits", "A rebase that involves complex merge conflicts", "None of the above"), 1))
        questionList.add(QModel(10, "What does 'interactive rebasing' allow you to do?", mutableListOf("Modify commits, reorder them, or squash multiple commits into one", "Only merge branches", "Create new branches", "None of the above"), 1))
        questionList.add(QModel(11, "Which command initiates an interactive rebase?", mutableListOf("git rebase -i", "git merge -i", "git branch -i", "git commit -i"), 1))
        questionList.add(QModel(12, "What should you do if you encounter conflicts during a rebase?", mutableListOf("Resolve conflicts and continue the rebase", "Abort the rebase", "Ignore the conflicts", "None of the above"), 1))
        questionList.add(QModel(13, "What does the command 'git rebase --abort' do?", mutableListOf("Cancels the rebase process and restores the branch to its original state", "Commits the changes", "Starts a new branch", "None of the above"), 1))
        questionList.add(QModel(14, "After rebasing, what command do you use to update the remote repository?", mutableListOf("git push --force", "git push", "git merge", "git pull"), 1))
        questionList.add(QModel(15, "Why might you need to use 'git push --force' after a rebase?", mutableListOf("Because the commit history has been rewritten", "Because you created a new branch", "To delete a branch", "None of the above"), 1))
        questionList.add(QModel(16, "What is the difference between 'git rebase' and 'git pull --rebase'?", mutableListOf("git pull --rebase fetches changes and rebases them onto your current branch", "Both commands are identical", "git rebase is used to merge branches", "None of the above"), 1))
        questionList.add(QModel(17, "How does rebasing affect collaboration with other developers?", mutableListOf("Can create confusion if not communicated properly", "Improves collaboration", "Has no effect", "None of the above"), 1))
        questionList.add(QModel(18, "What does the command 'git rebase origin/main' do?", mutableListOf("Rebases the current branch onto the latest commit from the main branch", "Merges the main branch into the current branch", "Creates a new branch from the main branch", "None of the above"), 1))
        questionList.add(QModel(19, "What should you do before starting a rebase?", mutableListOf("Ensure your working directory is clean", "Delete all branches", "Create new commits", "None of the above"), 1))
        questionList.add(QModel(20, "What is the primary goal of rebasing?", mutableListOf("To create a linear commit history", "To merge branches", "To delete old commits", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getEncryptionQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is encryption?", mutableListOf("The process of converting plaintext into ciphertext", "The process of decoding data", "The process of compressing files", "The process of sending data"), 1))
        questionList.add(QModel(2, "Which algorithm is commonly used for symmetric encryption?", mutableListOf("AES", "RSA", "SHA", "MD5"), 1))
        questionList.add(QModel(3, "What is the main difference between symmetric and asymmetric encryption?", mutableListOf("Symmetric uses the same key for encryption and decryption; asymmetric uses different keys", "Symmetric is faster than asymmetric", "Asymmetric is less secure than symmetric", "None of the above"), 1))
        questionList.add(QModel(4, "What is a key in encryption?", mutableListOf("A value used to encrypt and decrypt data", "A random number", "A password", "None of the above"), 1))
        questionList.add(QModel(5, "What is the purpose of a digital signature?", mutableListOf("To verify the authenticity and integrity of a message", "To encrypt data", "To compress files", "To hash passwords"), 1))
        questionList.add(QModel(6, "Which of the following is a common asymmetric encryption algorithm?", mutableListOf("RSA", "DES", "Blowfish", "AES"), 1))
        questionList.add(QModel(7, "What is hashing?", mutableListOf("A one-way function that converts data into a fixed-size string", "A method of encryption", "A type of compression", "None of the above"), 1))
        questionList.add(QModel(8, "What is the purpose of SSL/TLS?", mutableListOf("To secure communication over a computer network", "To encrypt files on a disk", "To create a backup of data", "None of the above"), 1))
        questionList.add(QModel(9, "What is a certificate authority (CA)?", mutableListOf("An entity that issues digital certificates", "A method of encryption", "A type of attack", "None of the above"), 1))
        questionList.add(QModel(10, "Which encryption method is used for securing online transactions?", mutableListOf("TLS/SSL", "DES", "AES", "RSA"), 1))
        questionList.add(QModel(11, "What is a brute-force attack?", mutableListOf("Trying all possible keys to decrypt data", "An attack that targets vulnerabilities in software", "A method of social engineering", "None of the above"), 1))
        questionList.add(QModel(12, "What is the main advantage of using asymmetric encryption?", mutableListOf("It allows secure key exchange without sharing the key", "It is faster than symmetric encryption", "It is easier to implement", "None of the above"), 1))
        questionList.add(QModel(13, "What does the term 'cipher' refer to?", mutableListOf("An algorithm for performing encryption and decryption", "A key used for encryption", "A type of attack", "None of the above"), 1))
        questionList.add(QModel(14, "What is data integrity?", mutableListOf("Ensuring that data is accurate and unaltered", "The process of encrypting data", "The speed of data transmission", "None of the above"), 1))
        questionList.add(QModel(15, "Which of the following is NOT a common encryption method?", mutableListOf("RSA", "MD5", "AES", "HTTP"), 4))
        questionList.add(QModel(16, "What is the purpose of public key infrastructure (PKI)?", mutableListOf("To manage digital certificates and public-key encryption", "To encrypt data", "To create backups", "None of the above"), 1))
        questionList.add(QModel(17, "What is end-to-end encryption?", mutableListOf("Data is encrypted on the sender's device and only decrypted on the recipient's device", "Data is encrypted only during transmission", "Data is encrypted using a symmetric key", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following is an example of a hashing algorithm?", mutableListOf("SHA-256", "RSA", "AES", "DES"), 1))
        questionList.add(QModel(19, "What is the purpose of encryption in data security?", mutableListOf("To protect data from unauthorized access", "To increase data size", "To make data readable", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following protocols uses encryption?", mutableListOf("HTTPS", "FTP", "SMTP", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getAuthenticationQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is authentication?", mutableListOf("The process of verifying the identity of a user", "The process of authorizing access to resources", "The process of encrypting data", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is NOT a common authentication method?", mutableListOf("Password-based authentication", "Biometric authentication", "Two-factor authentication", "Data encryption"), 4))
        questionList.add(QModel(3, "What does MFA stand for?", mutableListOf("Multi-Factor Authentication", "Multi-Feature Authentication", "Multiple-Factor Authorization", "None of the above"), 1))
        questionList.add(QModel(4, "What is the primary purpose of using a token in authentication?", mutableListOf("To maintain user session after logging in", "To encrypt data", "To authorize access to resources", "None of the above"), 1))
        questionList.add(QModel(5, "Which protocol is commonly used for authentication in web applications?", mutableListOf("OAuth", "FTP", "SMTP", "HTTP"), 1))
        questionList.add(QModel(6, "What is the difference between authentication and authorization?", mutableListOf("Authentication verifies identity, authorization verifies access rights", "They are the same", "Authentication is for users only, authorization is for resources", "None of the above"), 1))
        questionList.add(QModel(7, "What is a common way to securely store passwords?", mutableListOf("Hashing", "Encryption", "Plain text", "None of the above"), 1))
        questionList.add(QModel(8, "What is the purpose of a CAPTCHA in authentication?", mutableListOf("To prevent automated access", "To encrypt user data", "To store passwords", "None of the above"), 1))
        questionList.add(QModel(9, "Which of the following is a disadvantage of password-based authentication?", mutableListOf("Users often choose weak passwords", "It is always secure", "It is easy to implement", "None of the above"), 1))
        questionList.add(QModel(10, "What does the OAuth protocol primarily provide?", mutableListOf("Delegated access", "Encryption of data", "Two-factor authentication", "None of the above"), 1))
        questionList.add(QModel(11, "What is Single Sign-On (SSO)?", mutableListOf("A user can log in once and access multiple applications", "Logging in with multiple usernames", "A method for password recovery", "None of the above"), 1))
        questionList.add(QModel(12, "Which of the following is a common use case for biometric authentication?", mutableListOf("Fingerprint recognition", "Password input", "Security questions", "None of the above"), 1))
        questionList.add(QModel(13, "What is the role of a security token in authentication?", mutableListOf("To prove the identity of a user", "To encrypt communications", "To store user data", "None of the above"), 1))
        questionList.add(QModel(14, "What is two-factor authentication (2FA)?", mutableListOf("An additional security layer requiring two forms of verification", "Using two passwords", "Two different usernames", "None of the above"), 1))
        questionList.add(QModel(15, "What is a common risk associated with authentication?", mutableListOf("Phishing attacks", "Strong passwords", "User education", "None of the above"), 1))
        questionList.add(QModel(16, "What is the purpose of using OAuth 2.0?", mutableListOf("To authorize third-party applications without sharing passwords", "To encrypt data", "To authenticate users only", "None of the above"), 1))
        questionList.add(QModel(17, "What is a session in the context of authentication?", mutableListOf("A period where a user is logged in", "A method of storing passwords", "An authentication protocol", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following is a method to implement authentication in APIs?", mutableListOf("Bearer tokens", "JSON", "XML", "None of the above"), 1))
        questionList.add(QModel(19, "What should you do to secure API keys?", mutableListOf("Keep them secret and not expose them in public repositories", "Share them with everyone", "Store them in plain text", "None of the above"), 1))
        questionList.add(QModel(20, "What is the purpose of a refresh token?", mutableListOf("To obtain a new access token when the current one expires", "To authenticate users", "To store user preferences", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getNetworkSecurityQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is network security?", mutableListOf("Protecting networks from unauthorized access and attacks", "The process of speeding up network traffic", "Managing network hardware", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is a common type of network attack?", mutableListOf("DDoS", "SQL Injection", "Phishing", "All of the above"), 4))
        questionList.add(QModel(3, "What is a firewall?", mutableListOf("A security device that monitors and controls incoming and outgoing network traffic", "A type of virus", "A method of data encryption", "None of the above"), 1))
        questionList.add(QModel(4, "What is the purpose of a VPN?", mutableListOf("To create a secure connection over a public network", "To block network traffic", "To manage IP addresses", "None of the above"), 1))
        questionList.add(QModel(5, "What does 'authentication' mean in network security?", mutableListOf("Verifying the identity of a user or device", "Encrypting data", "Blocking unauthorized access", "None of the above"), 1))
        questionList.add(QModel(6, "Which protocol is commonly used to secure web traffic?", mutableListOf("HTTPS", "FTP", "HTTP", "SMTP"), 1))
        questionList.add(QModel(7, "What is a common method to prevent unauthorized access?", mutableListOf("Using strong passwords", "Disabling firewalls", "Ignoring software updates", "None of the above"), 1))
        questionList.add(QModel(8, "What is malware?", mutableListOf("Malicious software designed to harm or exploit any programmable device", "A type of network protocol", "A hardware component", "None of the above"), 1))
        questionList.add(QModel(9, "What is social engineering?", mutableListOf("Manipulating individuals into divulging confidential information", "An encryption technique", "A type of network hardware", "None of the above"), 1))
        questionList.add(QModel(10, "What is a DDoS attack?", mutableListOf("Distributed Denial of Service, an attack that overwhelms a network with traffic", "A method of data encryption", "A type of firewall", "None of the above"), 1))
        questionList.add(QModel(11, "What is two-factor authentication?", mutableListOf("A security process in which the user provides two different authentication factors", "Using two passwords", "A method of data encryption", "None of the above"), 1))
        questionList.add(QModel(12, "Which of the following helps to secure a wireless network?", mutableListOf("Using WPA2 encryption", "Leaving the network open", "Using the default password", "None of the above"), 1))
        questionList.add(QModel(13, "What is the function of an intrusion detection system (IDS)?", mutableListOf("To monitor network traffic for suspicious activity", "To encrypt data", "To manage user accounts", "None of the above"), 1))
        questionList.add(QModel(14, "What is phishing?", mutableListOf("A fraudulent attempt to obtain sensitive information by disguising as a trustworthy entity", "A type of malware", "A method of encryption", "None of the above"), 1))
        questionList.add(QModel(15, "What is a botnet?", mutableListOf("A collection of compromised computers controlled by an attacker", "A type of firewall", "An encryption technique", "None of the above"), 1))
        questionList.add(QModel(16, "What does encryption do in network security?", mutableListOf("Protects data by converting it into a code", "Slows down network speed", "Isolates networks", "None of the above"), 1))
        questionList.add(QModel(17, "What is a security policy?", mutableListOf("A formal document outlining security measures and protocols", "A type of software", "A network hardware", "None of the above"), 1))
        questionList.add(QModel(18, "What is network segmentation?", mutableListOf("Dividing a network into smaller parts to improve security and performance", "Increasing network speed", "Adding more devices", "None of the above"), 1))
        questionList.add(QModel(19, "What is the purpose of regular software updates?", mutableListOf("To patch vulnerabilities and improve security", "To slow down the system", "To change the network configuration", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following is NOT a network security practice?", mutableListOf("Ignoring security alerts", "Implementing strong passwords", "Regularly backing up data", "Using encryption"), 1))

        setUpRecyclerView(questionList)
    }
    private fun getCryptographyQuestions() {
        val questionList = mutableListOf<QModel>()

        questionList.add(QModel(1, "What is cryptography?", mutableListOf("The practice of securing communication from adversaries", "The study of secret codes", "The science of encrypting data", "None of the above"), 1))
        questionList.add(QModel(2, "Which of the following is NOT a type of cryptography?", mutableListOf("Symmetric cryptography", "Asymmetric cryptography", "Hash functions", "Data encoding"), 4))
        questionList.add(QModel(3, "What is the primary purpose of symmetric cryptography?", mutableListOf("To use the same key for encryption and decryption", "To use different keys for encryption and decryption", "To hash data", "None of the above"), 1))
        questionList.add(QModel(4, "Which algorithm is commonly used in symmetric cryptography?", mutableListOf("RSA", "AES", "SHA-256", "ECC"), 2))
        questionList.add(QModel(5, "What is the main advantage of asymmetric cryptography?", mutableListOf("Uses two keys for encryption and decryption", "Faster than symmetric cryptography", "Easier to implement", "None of the above"), 1))
        questionList.add(QModel(6, "What does RSA stand for?", mutableListOf("Rivest-Shamir-Adleman", "Random Symmetric Algorithm", "Robust Security Algorithm", "None of the above"), 1))
        questionList.add(QModel(7, "What is a hash function?", mutableListOf("A function that converts input data into a fixed-size string", "An encryption algorithm", "A method of digital signature", "None of the above"), 1))
        questionList.add(QModel(8, "Which of the following is a common use of hashing?", mutableListOf("Password storage", "Data encryption", "Key exchange", "None of the above"), 1))
        questionList.add(QModel(9, "What is a digital signature?", mutableListOf("A cryptographic method to verify authenticity and integrity of data", "An encryption method", "A type of hash function", "None of the above"), 1))
        questionList.add(QModel(10, "What is the main use of Public Key Infrastructure (PKI)?", mutableListOf("To manage digital certificates and public-key encryption", "To encrypt data", "To hash passwords", "None of the above"), 1))
        questionList.add(QModel(11, "What is a common vulnerability in cryptography?", mutableListOf("Weak key management", "Strong encryption algorithms", "Secure hash functions", "None of the above"), 1))
        questionList.add(QModel(12, "Which cryptographic method is used in SSL/TLS protocols?", mutableListOf("Asymmetric cryptography", "Symmetric cryptography", "Both symmetric and asymmetric cryptography", "None of the above"), 3))
        questionList.add(QModel(13, "What is salting in cryptography?", mutableListOf("Adding random data to passwords before hashing", "Encrypting data", "Using multiple keys", "None of the above"), 1))
        questionList.add(QModel(14, "Which of the following is a common hashing algorithm?", mutableListOf("MD5", "RSA", "AES", "Diffie-Hellman"), 1))
        questionList.add(QModel(15, "What is the purpose of cryptographic keys?", mutableListOf("To encrypt and decrypt data", "To hash data", "To manage digital signatures", "None of the above"), 1))
        questionList.add(QModel(16, "What is a brute-force attack?", mutableListOf("Trying all possible keys to decrypt data", "A method of hashing", "A type of digital signature", "None of the above"), 1))
        questionList.add(QModel(17, "What does the term 'cipher' refer to?", mutableListOf("An algorithm for encryption and decryption", "A type of hash function", "A digital signature method", "None of the above"), 1))
        questionList.add(QModel(18, "Which of the following is an example of a symmetric encryption algorithm?", mutableListOf("RSA", "AES", "Diffie-Hellman", "ECC"), 2))
        questionList.add(QModel(19, "What is the purpose of a key exchange algorithm?", mutableListOf("To securely share cryptographic keys", "To hash data", "To encrypt files", "None of the above"), 1))
        questionList.add(QModel(20, "Which of the following is an essential property of a cryptographic hash function?", mutableListOf("Pre-image resistance", "Slow computation", "Ease of encryption", "None of the above"), 1))

        setUpRecyclerView(questionList)
    }































}


