//
//  TodoRow.swift
//  iosApp
//
//  Created by Ahmed Mh on 18/03/2022.
//

import SwiftUI
import shared

struct TodoRow: View {
    
    let todo: Todo
    let iconSystemName: String
    let function: ((Todo) -> Void)
    
    init(todo: Todo, icon: String, function: @escaping ((Todo) -> Void)){
        self.todo = todo
        self.iconSystemName = icon
        self.function = function
    }
    
    var body: some View {
        HStack {
            VStack(
                alignment: .leading
            ) {
                Text(todo.title)
                Text(todo.completed ? "completed" : "pending")
                    .foregroundColor(todo.completed ? .green : .red)
            }
            Spacer()
            Button(action: {
                function(todo)
            }, label: {
                Image(systemName: iconSystemName)
            })
        }.padding(10.0)
        .overlay(
            RoundedRectangle(
                cornerRadius: 10.0
            )
            .stroke(
                Color.black, lineWidth: 1.0
            )
        )
    }
}

struct TodoRow_Previews: PreviewProvider {
    static var previews: some View {
        TodoRow(todo: Todo(todoId: 0, title: "complete the demo", completed: true), icon: "plus"){ _ in }
    }
}
