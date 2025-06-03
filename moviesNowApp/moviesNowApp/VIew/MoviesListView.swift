import SwiftUI
import shared

struct Movie: Identifiable {
    let id = UUID()
    let title: String
    let year: Int
    let rating: Double
    let imageUrlString: String
}

struct MoviesListView: View {
    @StateViewModel var viewModel = SharedViewModelModule.shared.getMoviesNowViewModel()

    var body: some View {
        NavigationView {
            ScrollView {
                VStack(spacing: 20) {
                    HStack {
                        Text("Movies Now")
                            .font(.largeTitle)
                            .fontWeight(.bold)
                            .foregroundColor(.red)
                        Spacer()
                    }
                    .padding(.horizontal)

                    ForEach(movies) { movie in
                        MovieCard(movie: movie)
                    }
                }
                .padding(.vertical)
            }
            .navigationBarHidden(true)
            .background(Color.gray.opacity(0.1).ignoresSafeArea())
        }
    }
}

struct MovieCard: View {
    let movie: Movie

    var body: some View {
        VStack(alignment: .leading) {
            AsyncImage(url: URL(string: movie.imageUrlString)) { phase in
                switch phase {
                case .empty:
                    ProgressView()
                        .frame(maxWidth: .infinity, minHeight: 200)
                        .background(Color.gray.opacity(0.3))
                case .success(let image):
                    image
                        .resizable()
                        .scaledToFill()
                        .frame(height: 200)
                        .clipped()
                case .failure:
                    Image(systemName: "photo.fill")
                        .resizable()
                        .scaledToFit()
                        .frame(height: 100)
                        .foregroundColor(.gray)
                        .frame(maxWidth: .infinity, minHeight: 200)
                        .background(Color.gray.opacity(0.3))
                @unknown default:
                    EmptyView()
                }
            }
            .frame(maxWidth: .infinity)
            .background(Color.black)

            VStack(alignment: .leading, spacing: 5) {
                Text(movie.title)
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(.red)

                HStack(spacing: 5) {
                    Image(systemName: "star.fill").foregroundColor(.yellow)

                    Text(String(format: "%.1f", movie.rating))
                        .font(.subheadline)
                        .foregroundColor(.black)
                    Text("•")
                        .font(.subheadline)
                        .foregroundColor(.black)
                    Text(String(movie.year))
                        .font(.subheadline)
                        .foregroundColor(.black)
                }
            }
            .padding([.horizontal, .bottom])
        }
        .background(Color.white)
        .cornerRadius(10)
        .shadow(radius: 5)
        .padding(.horizontal)
    }
}

struct MoviesListView_Previews: PreviewProvider {
	static var previews: some View {
		MoviesListView()
	}
}