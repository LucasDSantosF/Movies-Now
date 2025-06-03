import SwiftUI

struct FailedMovieListView: View {
    let errorMsg: String
    var retryAction: () -> Void

    var body: some View {
        VStack {
            MoviesHeaderView()
            Spacer()
            
            Text("Algo deu errado ao buscar os dados")
                .font(.title2)
                .fontWeight(.semibold)
                .foregroundColor(ColorTheme.primary)
                .multilineTextAlignment(.center)
            Text(errorMsg)
                .foregroundColor(ColorTheme.secondary)
                .padding(.top, 5)
                
            Spacer()
            Button(action: { retryAction() }) {
                Text("Tentar novamente")
                    .foregroundColor(ColorTheme.tertiary)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(ColorTheme.primary)
                    .cornerRadius(8)
            }
            .padding()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(ColorTheme.secondary)
        .ignoresSafeArea(edges: .top)
    }
}

struct FailedMovieListView_Previews: PreviewProvider {
    static var previews: some View {
        FailedMovieListView(errorMsg: "Error", retryAction: {})
    }
}