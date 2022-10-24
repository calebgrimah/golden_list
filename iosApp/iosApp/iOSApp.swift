import SwiftUI
import shared

@main
struct iOSApp: App {
   init() {
        KoinCommonKt.doInitKoin()
       @ObservedObject var viewModel: GoldenListViewmodel
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
