//
//  GoldenListViewmodel.swift
//  iosApp
//
//  Created by Caleb.Grimah on 24/10/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync

enum  UIState{
    case LOADING,NORMAL,EMPTY, ERROR
}

@MainActor
class GoldenListViewmodel : ObservableObject  {
//    private let repository = JobRepository.initialize()
    
    @Published public var remoteList: [JobListing] = []
    @Published public var localList: [JobListing] = []
    
    

    init() async {
//        remoteList = []
        _ =  await fetchListings()
    }
    
    
    func fetchListings() async -> [JobListing]{
        do {
            let data =   try await asyncFunction(for: FetchJobListingsUseCase.init().invokeNative())
            print(data!.count.description)
            return []
        } catch {
            print("unable to load listing use cases")
            return []
        }
    }
//
//    func getJobListings(){
//        state = UIState.LOADING
//
//         createSingle(for: getBreeds.invokeNative()).subscribe(onSuccess: { _ in
//             DispatchQueue.main.async {
//                 self.state = State.NORMAL
//             }
//         }, onFailure: { error in
//             DispatchQueue.main.async {
//                 self.state = State.ERROR
//             }
//         }).disposed(by: disposeBag)
//     }
}
