//
//  RemoteTodosScreen.swift
//  iosApp
//
//  Created by Ahmed Mh on 18/03/2022.
//

import SwiftUI
import shared


struct RemoteTodosScreen: View {
    
    @State var todoList: [Todo] =  []
    let viewModel = RemoteTodoViewModel()
    
    var body: some View {
        VStack {
            TodoList(todoList: todoList, icon: "plus"){ todo in
                viewModel.createTodo(todo: todo)
            }
        }.onAppear(perform: {
            viewModel.collectTodos { newList in
                self.todoList = newList
            }
        })
    }
}

struct RemoteTodosScreen_Previews: PreviewProvider {
    static var previews: some View {
        RemoteTodosScreen()
    }
}
