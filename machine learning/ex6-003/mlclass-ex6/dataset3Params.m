function [C, sigma] = dataset3Params(X, y, Xval, yval)
%EX6PARAMS returns your choice of C and sigma for Part 3 of the exercise
%where you select the optimal (C, sigma) learning parameters to use for SVM
%with RBF kernel
%   [C, sigma] = EX6PARAMS(X, y, Xval, yval) returns your choice of C and 
%   sigma. You should complete this function to return the optimal C and 
%   sigma based on a cross-validation set.
%

% You need to return the following variables correctly.
C = 1;
sigma = 0.3;

% ====================== YOUR CODE HERE ======================
% Instructions: Fill in this function to return the optimal C and sigma
%               learning parameters found using the cross validation set.
%               You can use svmPredict to predict the labels on the cross
%               validation set. For example, 
%                   predictions = svmPredict(model, Xval);
%               will return the predictions on the cross validation set.
%
%  Note: You can compute the prediction error using 
%        mean(double(predictions ~= yval))

cMatrix = [0.5,1,3];
sMatrix = [0.05,0.1,0.2];
cLen = length(cMatrix);
sLen = length(sMatrix); 
minError = Inf;

for i=1:cLen
	for j=1:sLen
		model = svmTrain(X,y,cMatrix(i), @(x1,x2) gaussianKernel(x1,x2,sMatrix(j)));
		pred = svmPredict(model,Xval);
		cross_error = mean(double(pred ~= yval));
        if cross_error < minError
			minError = cross_error;
			C = cMatrix(i);
			sigma = sMatrix(j);
		end
	end
end


% =========================================================================

end
