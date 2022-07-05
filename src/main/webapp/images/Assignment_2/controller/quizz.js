function quizz_controller($scope,$http) {
    $scope.List_quiz = []
    $scope.lst_da = []

    const startingMinutes = 0.2
    let time = startingMinutes * 60
    setInterval( coutdown , 1000 )
    const cdEID = document.getElementById('cout')

    function coutdown() {
        const minutes = Math.floor(time / 60)
        let secconds = time % 60
        cdEID.innerHTML = `<h2> Thời Gian ${minutes} : ${secconds}</h2>`
        if (minutes == 0 && secconds == 0) {
            time = 0
            return
        }
        time--
    }

    const urlqz = 'https://6213a3d489fad53b1ffc094a.mockapi.io/quizz';
    $http.get(urlqz) // Gửi 1 request dạng GET tới API
        .then(function (response) {
            $scope.List_quiz = response.data;
            
        })
        .catch(function (error) {
            console.error(error);
    });
    $scope.submit = function () {
        var diem = 0
        for (let i = 0; i < $scope.List_quiz.length; i++) {
            if ($scope.List_quiz[i].da == $scope.lst_da[i].da) {
                diem = diem + 1
            }
        }
        const diemtb = ((100 / $scope.List_quiz.length ) * diem ) / 10
        swal("Nộp bài thành công", "Bạn đã đúng: "+ diem +" / "+$scope.List_quiz.length + "\nĐiểm của bạn là: "+diemtb, "success");
    }
    
}