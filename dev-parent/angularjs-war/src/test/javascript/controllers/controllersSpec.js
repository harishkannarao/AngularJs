describe('PhoneCat controllers', function() {

  describe('PhoneListCtrl', function(){
    var scope, ctrl, $httpBackend;

    // Load our app module definition before each test.
    beforeEach(module('phonecatApp'));

    // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
    // This allows us to inject a service but then attach it to a variable
    // with the same name as the service in order to avoid a name conflict.
    beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
      $httpBackend = _$httpBackend_;
      $httpBackend.expectGET('/restapi/service/phones').
          respond([{name: 'Nexus S'}, {name: 'Motorola DROID'}]);

      scope = $rootScope.$new();
      ctrl = $controller('PhoneListCtrl', {$scope: scope});
    }));

    it('should create "phones" model with 2 phones fetched from xhr', function() {
      expect(scope.phones).toBeUndefined();
      $httpBackend.flush();

      expect(scope.phones).toEqual([{name: 'Nexus S'},
                                   {name: 'Motorola DROID'}]);
    });


    it('should set the default value of orderProp model', function() {
      expect(scope.orderProp).toBe('age');
    });

    it('should set the name model', function() {
      expect(scope.name).toBe('World');
    });
  });

  describe('PhoneDetailCtrl', function(){
    var scope, rootScope, $httpBackend, ctrl, routeParams, controller;

    // Load our app module definition before each test.
    beforeEach(module('phonecatApp'));

    beforeEach(inject(function(_$httpBackend_, $rootScope, $routeParams, $controller) {
      $httpBackend = _$httpBackend_;
      rootScope = $rootScope;
      routeParams = $routeParams;
      controller = $controller;
    }));

    it('should fetch phone detail', function() {
      scope = rootScope.$new();
      expect(scope.phone).toBeUndefined();
      routeParams.phoneId = 'xyz';
      $httpBackend.expectGET('/restapi/service/phones/xyz').respond({name:'phone xyz'});
      ctrl = controller('PhoneDetailCtrl', {$scope: scope});
      $httpBackend.flush();

      expect(rootScope.title).toEqual('Google Phone Gallery: phone xyz');
      expect(scope.phone).toEqual({name:'phone xyz'});
      expect(scope.phoneId).toEqual('xyz');
    });
  });
});