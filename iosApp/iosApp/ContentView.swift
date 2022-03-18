//
//  ContentView.swift
//  iosApp
//
//  Created by Ahmed Mh on 18/03/2022.
//

import SwiftUI
import shared

//main screen
struct ContentView: View {
    
    var body: some View {
        TabView {
            RemoteTodosScreen()
                .tabItem {
                    Image(systemName: "house")
                    Text("Home")
                }
            LocalTodosScreen()
                .tabItem {
                    Image(systemName: "square.and.arrow.down")
                    Text("Local")
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
