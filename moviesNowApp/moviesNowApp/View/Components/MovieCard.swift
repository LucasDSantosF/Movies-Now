import SwiftUI
import shared

struct MovieCard: View {
    let movie: Movie

    var body: some View {
        VStack(alignment: .leading) {
            //Esse codigo foi feito com AI, pois ainda não tinha trabalhado com AsyncImage antes.
            AsyncImage(url: URL(string: movie.posterUrl)) { phase in
                switch phase {
                case .empty:
                    ProgressView()
                        .frame(maxWidth: .infinity, minHeight: 200)
                        .background(ColorTheme.secondary)
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
                        .foregroundColor(ColorTheme.secondary)
                        .frame(maxWidth: .infinity, minHeight: 200)
                        .background(ColorTheme.secondary)
                @unknown default:
                    EmptyView()
                }
            }
            .frame(maxWidth: .infinity)
            .background(ColorTheme.primary)

            VStack(alignment: .leading, spacing: 5) {
                Text(movie.title)
                    .font(.title2)
                    .fontWeight(.bold)
                    .foregroundColor(ColorTheme.tertiary)

                    
            Text("⭐ \(String(format: "%.1f", movie.rating))  ◼  \(String(movie.releaseYear))")
                        .font(.subheadline)
                        .foregroundColor(ColorTheme.tertiary)
            }
            .padding([.horizontal, .bottom])
        }
        .background(ColorTheme.primary)
        .cornerRadius(10)
        .shadow(radius: 5)
        .padding(.horizontal)
    }
}