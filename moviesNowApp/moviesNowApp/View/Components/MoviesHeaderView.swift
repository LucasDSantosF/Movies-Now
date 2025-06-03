import SwiftUI

struct MoviesHeaderView: View {
    var body: some View {
        HStack {
            Text("Movies Now")
                .font(.largeTitle)
                .fontWeight(.bold)
                .foregroundColor(ColorTheme.tertiary)
            Spacer()
        }
        .foregroundColor(ColorTheme.primary)
        .padding(.horizontal)
    }
}

struct MoviesListView_Previews: PreviewProvider {
	static var previews: some View {
		MoviesHeaderView()
	}
}