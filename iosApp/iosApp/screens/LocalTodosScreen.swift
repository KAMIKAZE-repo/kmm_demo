//
//  LocalTodosScreen.swift
//  iosApp
//
//  Created by Ahmed Mh on 18/03/2022.
//

import SwiftUI
import shared


struct LocalTodosScreen: View {
    
    @State var todosList: [Todo] = []
    let viewModel = LocalTodosViewModel()
    
    var body: some View {
        VStack {
            TodoList(todoList: todosList, icon: "trash"){ todo in
                viewModel.deleteTodo(todoId: todo.todoId)
            }
        }.onAppear(perform: {
            viewModel.collectTodos { todosList in
                self.todosList = todosList
            }
        })
        
    }
    
}

struct LocalTodosScreen_Previews: PreviewProvider {
    static var previews: some View {
        LocalTodosScreen()
    }
}
