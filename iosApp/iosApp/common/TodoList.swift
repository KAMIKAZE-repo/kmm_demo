//
//  TodoList.swift
//  iosApp
//
//  Created by Ahmed Mh on 18/03/2022.
//

import SwiftUI
import shared


struct TodoList: View {
    
    let todoList: [Todo]
    let iconSystemName: String
    let function: ((Todo) -> Void)
    
    
    init(todoList: [Todo], icon: String, function:@escaping ((Todo) -> Void)) {
        self.todoList = todoList
        self.iconSystemName = icon
        self.function = function
    }
    
    var body: some View {
        VStack {
            List(todoList, id: \.todoId){ todo in
                TodoRow(todo: todo, icon: iconSystemName){ todo in function(todo)
                }
            }
        }
    }
}

struct TodoList_Previews: PreviewProvider {
    static var previews: some View {
        TodoList(todoList: [], icon: "plus"){ _ in}
    }
}
