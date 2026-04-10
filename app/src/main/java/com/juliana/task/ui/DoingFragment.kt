package com.juliana.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliana.task.R
import com.juliana.task.data.model.Status
import com.juliana.task.data.model.Task
import com.juliana.task.databinding.FragmentDoingBinding
import com.juliana.task.databinding.FragmentLoginBinding
import com.juliana.task.databinding.FragmentTodoBinding
import com.juliana.task.ui.adapter.TaskAdapter


class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoingBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

        initRecyclerViewTask(getTask())
    }

    private fun initListeners(){
        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate((R.id.action_homeFragment_to_formTaskFragment))
        }
    }

    private fun initRecyclerViewTask(taskList: List<Task>){

        taskAdapter = TaskAdapter(taskList)
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.setHasFixedSize(true)

        binding.recyclerViewTask.adapter = taskAdapter
    }

    private fun getTask() = listOf(
        Task(id = "0", description = "Implementar API", Status.DOING),
        Task(id = "1", description = "Validar ideias", Status.DOING),
        Task(id = "2", description = "Adicionar usuários", Status.DOING),
        Task(id = "3", description = "Fazer banco de dados", Status.DOING),
        Task(id = "2", description = "Criar funcionalidade de login com face id no app", Status.DOING)
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}