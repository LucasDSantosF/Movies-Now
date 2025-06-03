import SwiftUI
import Shared

@main
struct iOSApp: App {

    init() {
        initKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}