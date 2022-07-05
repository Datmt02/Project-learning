function quantri_controller($scope,$http) {
    $scope.index=-1;
    $scope.List_student = []
    $scope.student = {}
    const url = 'https://6213a3d489fad53b1ffc094a.mockapi.io/user';
    $http.get(url) // Gửi 1 request dạng GET tới API
        .then(function (response) {
            $scope.List_student = response.data;
        })
        .catch(function (error) {
            console.error(error);
        });

    $scope.edit=function(index){
        $scope.index=index;     
        $scope.student=angular.copy($scope.List_student[index])
    }
    function getPath() {
        $('#filePath ').on('change',function ()
        {
            var filePath = $(this).val();
            $scope.student.avt = filePath.slice(12, );
        });
    }
    getPath();
    $scope.onFormSubmit = function (event) {
        event.preventDefault();
        if($scope.index == -1){
            for (let i = 0; i < $scope.List_student.length; i++) {
                if ($scope.List_student[i].email == $scope.student.email) {
                    swal("Email của bạn đã bị trùng", "", "error");
                    return
                }else{
                    $http.post(url, $scope.student)
                    .then(function (response) {
                        const sv = response.data;
                        $scope.List_student.push(sv);
                    });
                    swal("Thêm người dùng thành công", "", "success");
                    $scope.clear()
                    return
                }
            }
            return
        }else{
            const id = $scope.List_student[$scope.index].id
            const deleteApi = url + '/' + id;
            $http.put(deleteApi,$scope.student)
            .then(function (response) {    
                const sv = response.data;
                $scope.List_student[$scope.index]= sv
            });
            swal("Sửa người dùng thành công", "", "success");
            return
        }
    }
    $scope.clear =function(){
        $scope.student={}
        $scope.index=-1
    }

    $scope.Delete = function (index) {
        const id = $scope.List_student[index].id
        const deleteApi = url + '/' + id;
        $http.delete(deleteApi)
            .then(function (response) {          
                $scope.List_student.splice(index,1);
                $scope.index = -1
                swal("Xóa người dùng thành công", "", "success");
                $scope.clear()
            });
    }
    // Câu hỏi
    $scope.indexqz=-1;
    $scope.List_quiz = []
    $scope.quiz = {}
    const urlqz = 'https://6213a3d489fad53b1ffc094a.mockapi.io/quizz';
    $http.get(urlqz) // Gửi 1 request dạng GET tới API
        
        .then(function (response) {
            $scope.List_quiz = response.data;
        })
        .catch(function (error) {
            console.error(error);
        });

    $scope.editquiz=function(index){
        $scope.indexqz=index;     
        $scope.quiz=angular.copy($scope.List_quiz[index])
    }
    $scope.onFormSubmitquiz = function (event) {
        event.preventDefault();
        if($scope.indexqz == -1){
            for (let i = 0; i < $scope.List_quiz.length; i++) {
                if ($scope.List_quiz[i].document == $scope.quiz.document) {
                    swal("Câu hỏi của bạn đã bị trùng", "", "error");
                    return
                }else{
                    $http.post(urlqz, $scope.quiz)
                    .then(function (response) {
                        const qz = response.data;
                        $scope.List_quiz.push(qz);
                    });
                    swal("Thêm câu hỏi thành công", "", "success");
                    $scope.clear()
                    return
                }
            }
            return
        }else{
            const id = $scope.List_quiz[$scope.indexqz].id
            const deleteApi = urlqz + '/' + id;
            $http.put(deleteApi,$scope.quiz)
            .then(function (response) {    
                const qz = response.data;
                $scope.List_quiz[$scope.indexqz]= qz
            });
            swal("Sửa Câu hỏi thành công", "", "success");
            return
        }
    }
    $scope.clearquiz =function(){
        $scope.quiz={}
        $scope.indexqz=-1
    }

    $scope.Deletequiz = function (index) {
        const id = $scope.List_quiz[index].id
        const deleteApi = urlqz + '/' + id;
        $http.delete(deleteApi)
            .then(function (response) {          
                $scope.List_quiz.splice(index,1);
                $scope.indexqz = -1
                swal("Xóa hỏi thành công", "", "success");
                $scope.clearquiz()
            });
    }
}
